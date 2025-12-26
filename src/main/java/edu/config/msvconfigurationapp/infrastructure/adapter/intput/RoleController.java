package edu.config.msvconfigurationapp.infrastructure.adapter.intput;

import edu.config.msvconfigurationapp.application.usecase.RoleUseCase;
import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleUseCase useCase;

    @GetMapping
    public Mono<ResponseEntity<Flux<RoleResponse>>> getAll() {
        return Mono.just(ResponseEntity.ok(this.useCase.findAll()))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<RoleResponse>> getById(@PathVariable String id) {
        return this.useCase.findById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<RoleResponse>> save(@RequestBody RoleRequest request) {
        return this.useCase.save(request)
            .map(roleResponse -> ResponseEntity
                .created(URI.create("/api/v1/roles/"))
                .body(roleResponse))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.useCase.deleteById(id)
            .then(Mono.just(ResponseEntity.noContent().<Void>build()))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
