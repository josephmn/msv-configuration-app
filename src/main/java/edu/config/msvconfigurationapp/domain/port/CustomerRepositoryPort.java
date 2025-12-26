package edu.config.msvconfigurationapp.domain.port;

import edu.config.msvconfigurationapp.domain.model.CustomerRequest;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CustomerRepositoryPort interface defines the contract for customer repository operations.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
public interface CustomerRepositoryPort {
    Flux<CustomerResponse> findAll();
    Mono<CustomerResponse> findById(String id);
    Mono<CustomerResponse> save(CustomerRequest request);
    Mono<CustomerResponse> update(String id, CustomerRequest request);
    Mono<Void> deleteById(String id);
}
