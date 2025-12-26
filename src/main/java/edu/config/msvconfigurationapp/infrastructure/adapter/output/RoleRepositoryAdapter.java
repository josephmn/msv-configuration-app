package edu.config.msvconfigurationapp.infrastructure.adapter.output;

import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.domain.port.RoleRepositoryPort;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.RoleSpResult;
import edu.config.msvconfigurationapp.infrastructure.adapter.output.repository.RoleR2dbcRepository;
import edu.config.msvconfigurationapp.infrastructure.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepositoryPort {

    private final DatabaseClient databaseClient;
    private final RoleR2dbcRepository repository;
    private final RoleMapper mapper;

    @Override
    public Flux<RoleResponse> findAll() {
        return null;
//        return repository.findAll().map(mapper::toRoleResponse);
    }

    @Override
    public Mono<RoleResponse> findById(String id) {
        return null;
//        return repository.findById(id).map(mapper::toRoleResponse);
    }

    @Override
    public Mono<RoleResponse> save(RoleRequest request) {

        return databaseClient.sql("""
            EXEC security.spRole @v_nombre = :name, @v_estado = :status
            """)
            .bind("name", request.getNombre())
            .bind("status", request.getEstado())
            .map((row, meta) -> new RoleSpResult(
                row.get("Id", String.class),
                row.get("Name", String.class),
                row.get("IsActive", Boolean.class),
                row.get("CreateDate", LocalDateTime.class),
                row.get("NewCode", String.class),
                row.get("Message", String.class)
            ))
            .one()
            .flatMap(result -> {

                if (result.Message() != null && !result.Message().isBlank()) {
                    return Mono.error(new IllegalStateException(result.Message()));
                }

                return Mono.just(mapper.toRoleResponse(result));
            });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
