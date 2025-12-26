package edu.config.msvconfigurationapp.infrastructure.adapter.output;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.BiFunction;
import org.springframework.r2dbc.core.DatabaseClient;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.CustomerSpResult;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * BaseCustomerSpRepository provides common functionality for executing stored procedures
 * related to customers in the database.
 * It uses R2DBC DatabaseClient for reactive database access.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@RequiredArgsConstructor
public abstract class BaseCustomerSpRepository {

    protected final DatabaseClient databaseClient;

    protected BiFunction<Row, RowMetadata, CustomerSpResult> customerSpResultRowMapper() {
        return (row, meta) -> new CustomerSpResult(
            row.get("Id", String.class),
            row.get("Document", String.class),
            row.get("CompanyName", String.class),
            row.get("Email", String.class),
            row.get("Password", String.class),
            row.get("IsActive", Boolean.class),
            row.get("CreateDate", LocalDateTime.class),
            row.get("UpdateDate", LocalDateTime.class),
            row.get("Status", String.class),
            row.get("Message", String.class)
        );
    }

    protected Mono<CustomerSpResult> executeCustomerSpMono(String sql, Map<String, Object> params) {
        var spec = databaseClient.sql(sql);

        for (Map.Entry<String, Object> param : params.entrySet()) {
            spec = spec.bind(param.getKey(), param.getValue());
        }

        return spec.map(customerSpResultRowMapper()).one();
    }

    protected Flux<CustomerSpResult> executeCustomerSpFlux(String sql, Map<String, Object> params) {
        var spec = databaseClient.sql(sql);

        for (Map.Entry<String, Object> param : params.entrySet()) {
            spec = spec.bind(param.getKey(), param.getValue());
        }

        return spec.map(customerSpResultRowMapper()).all();
    }
}
