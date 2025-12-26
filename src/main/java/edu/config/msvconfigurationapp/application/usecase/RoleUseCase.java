package edu.config.msvconfigurationapp.application.usecase;

import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.domain.port.RoleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RoleUseCase {

    private final RoleRepositoryPort repository;

    public Mono<RoleResponse> save(RoleRequest request) {
        return repository.save(request);
    }

    public Mono<RoleResponse> findById(String id) {
        return repository.findById(id);
    }

    public Flux<RoleResponse> findAll() {
        return repository.findAll();
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
