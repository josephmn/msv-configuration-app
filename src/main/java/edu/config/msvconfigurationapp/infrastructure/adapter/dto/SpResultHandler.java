package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import org.springframework.stereotype.Component;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.infrastructure.exception.types.AlreadyExistsException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.InternalException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.NotContentException;
import edu.config.msvconfigurationapp.infrastructure.mapper.CustomerMapper;
import edu.config.msvconfigurationapp.infrastructure.mapper.RoleMapper;
import reactor.core.publisher.Mono;

/**
 * SpResultHandler class handles the results from stored procedures (SP) related to roles.
 * It maps the SP results to RoleResponse objects or throws appropriate exceptions based on the status.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Component
public class SpResultHandler {

    private final RoleMapper roleMapper;
    private final CustomerMapper customerMapper;

    /**
     * Constructor for SpResultHandler.
     *
     * @param roleMapper the RoleMapper to map SP results to RoleResponse
     * @param customerMapper the CustomerMapper to map SP results to CustomerResponse
     */
    public SpResultHandler(RoleMapper roleMapper, CustomerMapper customerMapper) {
        this.roleMapper = roleMapper;
        this.customerMapper = customerMapper;
    }

    /**
     * Handles the result of a role-related stored procedure.
     *
     * @param result the result from the stored procedure
     * @return a Mono emitting the RoleResponse or an error
     */
    public Mono<RoleResponse> handleRoleSpResult(RoleSpResult result) {
        return switch (result.getStatus()) {
            case "200", "201" -> Mono.just(roleMapper.toRoleResponse(result));
            case "204" -> Mono.error(new NotContentException(result.getMessage()));
            case "409" -> Mono.error(new AlreadyExistsException(result.getMessage()));
            case "500" -> Mono.error(new InternalException(result.getMessage()));
            default -> Mono.error(new InternalException("Estado desconocido del SP: " + result.getStatus()));
        };
    }

    /**
     * Handles the result of a customer-related stored procedure.
     *
     * @param result the result from the stored procedure
     * @return a Mono emitting the CustomerResponse or an error
     */
    public Mono<CustomerResponse> handleCustomerSpResult(CustomerSpResult result) {
        return switch (result.getStatus()) {
            case "200", "201" -> Mono.just(customerMapper.toCustomerResponse(result));
            case "204" -> Mono.error(new NotContentException(result.getMessage()));
            case "409" -> Mono.error(new AlreadyExistsException(result.getMessage()));
            case "500" -> Mono.error(new InternalException(result.getMessage()));
            default -> Mono.error(new InternalException("Estado desconocido del SP: " + result.getStatus()));
        };
    }
}
