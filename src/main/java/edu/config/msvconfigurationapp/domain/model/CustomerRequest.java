package edu.config.msvconfigurationapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustomerRequest class represents a request to create or update a customer.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String documento;
    private String compania;
    private String correo;
    private String contrasena;
    private Boolean estado;
}
