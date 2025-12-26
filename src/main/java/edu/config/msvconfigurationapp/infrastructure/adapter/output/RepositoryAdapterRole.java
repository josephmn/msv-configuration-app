package edu.config.msvconfigurationapp.infrastructure.adapter.output;

import java.util.Map;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.domain.port.RoleRepositoryPort;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.SpResultHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RoleRepositoryAdapter is an implementation of RoleRepositoryPort
 * that interacts with the database using stored procedures.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Service
public class RepositoryAdapterRole extends BaseRoleSpRepository implements RoleRepositoryPort {

    protected final String SP_ROLE_LIST = """
        EXEC security.spRoleList @v_post = :post, @v_code = :code
        """;

    protected final String SP_ROLE_SAVE = """
        EXEC security.spRoleSave @v_name = :name, @v_status = :status
        """;

    protected final String SP_ROLE_UPDATE = """
        EXEC security.spRoleUpdate @v_id = :id, @v_name = :name, @v_status = :status
        """;

    protected final String SP_ROLE_DELETE = """
        EXEC security.spRoleDelete @v_code = :code
        """;

    private final SpResultHandler spResultHandler;

    /**
     * Constructor for RoleRepositoryAdapter.
     *
     * @param databaseClient the DatabaseClient to use for database operations
     * @param spResultHandler the SpResultHandler to handle stored procedure results
     */
    public RepositoryAdapterRole(DatabaseClient databaseClient,
                                 SpResultHandler spResultHandler) {
        super(databaseClient);
        this.spResultHandler = spResultHandler;
    }

    @Override
    public Flux<RoleResponse> findAll() {
        final Map<String, Object> params = Map.of(
            "post", "0",
            "code", ""
        );

        return executeRoleSpFlux(SP_ROLE_LIST, params)
            .flatMap(this.spResultHandler::handleRoleSpResult);
    }

    @Override
    public Mono<RoleResponse> findById(String id) {
        final Map<String, Object> params = Map.of(
            "post", "1",
            "code", id
        );

        return executeRoleSpMono(SP_ROLE_LIST, params)
            .flatMap(this.spResultHandler::handleRoleSpResult);
    }

    @Override
    public Mono<RoleResponse> save(RoleRequest request) {
        final Map<String, Object> params = Map.of(
            "name", request.getNombre(),
            "status", request.getEstado()
        );

        return executeRoleSpMono(SP_ROLE_SAVE, params)
            .flatMap(this.spResultHandler::handleRoleSpResult);
    }

    @Override
    public Mono<RoleResponse> update(String id, RoleRequest request) {
        final Map<String, Object> params = Map.of(
            "id", id,
            "name", request.getNombre(),
            "status", request.getEstado()
        );

        return executeRoleSpMono(SP_ROLE_UPDATE, params)
            .flatMap(this.spResultHandler::handleRoleSpResult);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        final Map<String, Object> params = Map.of(
            "code", id
        );
        return executeRoleSpMono(SP_ROLE_DELETE, params)
            .flatMap(this.spResultHandler::handleRoleSpResult)
            .then();
    }
}
