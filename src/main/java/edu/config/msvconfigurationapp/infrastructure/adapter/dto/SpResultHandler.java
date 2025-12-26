package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import org.springframework.stereotype.Component;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.infrastructure.exception.types.AlreadyExistsException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.InternalException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.NotContentException;
import edu.config.msvconfigurationapp.infrastructure.mapper.RoleMapper;
import reactor.core.publisher.Flux;
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

    private final RoleMapper mapper;

    /**
     * Constructor for SpResultHandler.
     *
     * @param mapper the RoleMapper to map SP results to RoleResponse
     */
    public SpResultHandler(RoleMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Handles the result of a role-related stored procedure.
     *
     * @param result the result from the stored procedure
     * @return a Mono emitting the RoleResponse or an error
     */
    public Mono<RoleResponse> handleRoleSpResult(RoleSpResult result) {
        return switch (result.getStatus()) {
            case "200", "201" -> Mono.just(mapper.toRoleResponse(result));
            case "204" -> Mono.error(new NotContentException(result.getMessage()));
            case "409" -> Mono.error(new AlreadyExistsException(result.getMessage()));
            case "500" -> Mono.error(new InternalException(result.getMessage()));
            default -> Mono.error(new InternalException("Estado desconocido del SP: " + result.getStatus()));
        };
    }

    /**
     * Handles the result of a role-related stored procedure and returns a Flux.
     *
     * @param result the result from the stored procedure
     * @return a Flux emitting the RoleResponse or an error
     */
    public Flux<RoleResponse> handleRoleSpResultFlux(RoleSpResult result) {
        return handleRoleSpResult(result).flux();
    }
}
