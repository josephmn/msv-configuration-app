package edu.config.msvconfigurationapp.application.usecase;

import org.springframework.stereotype.Service;
import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.domain.port.RoleRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Use case class for managing roles.
 * Provides methods to save, find, and delete roles.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Service
@RequiredArgsConstructor
public class RoleUseCase {

    private final RoleRepositoryPort repository;

    public Flux<RoleResponse> findAll() {
        return repository.findAll();
    }

    public Mono<RoleResponse> findById(String id) {
        return repository.findById(id);
    }

    public Mono<RoleResponse> save(RoleRequest request) {
        return repository.save(request);
    }

    public Mono<RoleResponse> update(String id, RoleRequest request) {
        return repository.update(id, request);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
