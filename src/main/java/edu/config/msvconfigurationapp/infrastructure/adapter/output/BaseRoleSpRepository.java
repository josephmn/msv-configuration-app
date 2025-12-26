package edu.config.msvconfigurationapp.infrastructure.adapter.output;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.BiFunction;
import org.springframework.r2dbc.core.DatabaseClient;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.RoleSpResult;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * BaseSpRepository provides common functionality for executing stored procedures
 * related to roles in the database.
 * It uses R2DBC DatabaseClient for reactive database access.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@RequiredArgsConstructor
public abstract class BaseRoleSpRepository {

    protected final DatabaseClient databaseClient;

    protected BiFunction<Row, RowMetadata, RoleSpResult> roleSpResultRowMapper() {
        return (row, meta) -> new RoleSpResult(
            row.get("Id", String.class),
            row.get("Name", String.class),
            row.get("IsActive", Boolean.class),
            row.get("CreateDate", LocalDateTime.class),
            row.get("UpdateDate", LocalDateTime.class),
            row.get("Status", String.class),
            row.get("Message", String.class)
        );
    }

    protected Mono<RoleSpResult> executeRoleSpMono(String sql, Map<String, Object> params) {
        var spec = databaseClient.sql(sql);

        for (Map.Entry<String, Object> param : params.entrySet()) {
            spec = spec.bind(param.getKey(), param.getValue());
        }

        return spec.map(roleSpResultRowMapper()).one();
    }

    protected Flux<RoleSpResult> executeRoleSpFlux(String sql, Map<String, Object> params) {
        var spec = databaseClient.sql(sql);

        for (Map.Entry<String, Object> param : params.entrySet()) {
            spec = spec.bind(param.getKey(), param.getValue());
        }

        return spec.map(roleSpResultRowMapper()).all();
    }
}
