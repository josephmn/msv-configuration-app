package edu.config.msvconfigurationapp.domain.port;

import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RoleRepositoryPort interface defines the contract for role repository operations.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
public interface RoleRepositoryPort {
    Flux<RoleResponse> findAll();
    Mono<RoleResponse> findById(String id);
    Mono<RoleResponse> save(RoleRequest request);
    Mono<RoleResponse> update(String id, RoleRequest request);
    Mono<Void> deleteById(String id);
}
