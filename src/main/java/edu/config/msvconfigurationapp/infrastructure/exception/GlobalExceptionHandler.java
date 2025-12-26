package edu.config.msvconfigurationapp.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import edu.config.msvconfigurationapp.infrastructure.exception.types.AlreadyExistsException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.InternalException;
import edu.config.msvconfigurationapp.infrastructure.exception.types.NotContentException;
import reactor.core.publisher.Mono;

/**
 * GlobalExceptionHandler class handles exceptions thrown by the application.
 * It provides custom error responses for different types of exceptions.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle NotContentException and return a 204 response.
     *
     * @param exception the NotContentException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(NotContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<ErrorResponse>>handleNotFoundException(NotContentException exception) {
        final ErrorResponse error = new ErrorResponse(
            HttpStatus.NO_CONTENT.value(),
            exception.getMessage()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).body(error));
    }

    /**
     * Handle CustomerAlreadyExistsException and return a 409 response.
     *
     * @param exception the CustomerAlreadyExistsException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Mono<ResponseEntity<ErrorResponse>> handleNotFoundException(AlreadyExistsException exception) {
        final ErrorResponse error = new ErrorResponse(
            HttpStatus.CONFLICT.value(),
            exception.getMessage()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(error));
    }

    /**
     * Handle CustomerAlreadyExistsException and return a 409 response.
     *
     * @param exception the CustomerAlreadyExistsException
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(InternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ResponseEntity<ErrorResponse>> handleInternalException(InternalException exception) {
        final ErrorResponse error = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            exception.getMessage()
        );
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }
}
