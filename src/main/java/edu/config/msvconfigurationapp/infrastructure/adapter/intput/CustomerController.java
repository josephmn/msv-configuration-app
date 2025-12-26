package edu.config.msvconfigurationapp.infrastructure.adapter.intput;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.config.msvconfigurationapp.application.usecase.CustomerUseCase;
import edu.config.msvconfigurationapp.domain.model.CustomerRequest;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * CustomerController class handles HTTP requests for customer management.
 * It provides an endpoint to create customers.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    @PostMapping
    public Mono<ResponseEntity<CustomerResponse>> save(@RequestBody CustomerRequest request) {
        return this.customerUseCase.save(request)
            .map(roleResponse -> ResponseEntity
                .created(URI.create("/api/v1/customers/"))
                .body(roleResponse))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
