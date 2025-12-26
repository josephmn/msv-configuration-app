package edu.config.msvconfigurationapp.application.usecase;

import org.springframework.stereotype.Service;
import edu.config.msvconfigurationapp.domain.model.CustomerRequest;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import edu.config.msvconfigurationapp.domain.port.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Use case class for managing customers.
 * Provides methods to save, find, and delete customers.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Service
@RequiredArgsConstructor
public class CustomerUseCase {

    private final CustomerRepositoryPort repository;

    public Flux<CustomerResponse> findAll() {
        return repository.findAll();
    }

    public Mono<CustomerResponse> findById(String id) {
        return repository.findById(id);
    }

    public Mono<CustomerResponse> save(CustomerRequest request) {
        return repository.save(request);
    }

    public Mono<CustomerResponse> update(String id, CustomerRequest request) {
        return repository.update(id, request);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
