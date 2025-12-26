package edu.config.msvconfigurationapp.infrastructure.adapter.output;

import java.util.Map;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import edu.config.msvconfigurationapp.domain.model.CustomerRequest;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import edu.config.msvconfigurationapp.domain.port.CustomerRepositoryPort;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.SpResultHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CustomerRepositoryAdapter is an implementation of CustomerRepositoryPort
 * that interacts with the database using stored procedures.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Service
public class RepositoryAdapterCustomer extends BaseCustomerSpRepository implements CustomerRepositoryPort {

//    protected final String SP_ROLE_LIST = """
//        EXEC security.spRoleList @v_post = :post, @v_code = :code
//        """;

    protected final String SP_CUSTOMER_SAVE = """
        EXEC platform.spCustomerSave @v_document = :document, @v_company = :company,\s
        @v_email = :email, @v_password = :password, @v_status = :status
       \s""";

//    protected final String SP_ROLE_UPDATE = """
//        EXEC security.spRoleUpdate @v_id = :id, @v_name = :name, @v_status = :status
//        """;
//
//    protected final String SP_ROLE_DELETE = """
//        EXEC security.spRoleDelete @v_code = :code
//        """;

    private final SpResultHandler spResultHandler;

    /**
     * Constructor for RoleRepositoryAdapter.
     *
     * @param databaseClient the DatabaseClient to use for database operations
     * @param spResultHandler the SpResultHandler to handle stored procedure results
     */
    public RepositoryAdapterCustomer(DatabaseClient databaseClient,
                                 SpResultHandler spResultHandler) {
        super(databaseClient);
        this.spResultHandler = spResultHandler;
    }

    @Override
    public Flux<CustomerResponse> findAll() {
        return null;
    }

    @Override
    public Mono<CustomerResponse> findById(String id) {
        return null;
    }

    @Override
    public Mono<CustomerResponse> save(CustomerRequest request) {
        final Map<String, Object> params = Map.of(
            "document", request.getDocumento(),
            "company", request.getCompania(),
            "email", request.getCorreo(),
            "password", request.getContrasena(),
            "status", request.getEstado()
        );

        return executeCustomerSpMono(SP_CUSTOMER_SAVE, params)
            .flatMap(this.spResultHandler::handleCustomerSpResult);
    }

    @Override
    public Mono<CustomerResponse> update(String id, CustomerRequest request) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }
}
