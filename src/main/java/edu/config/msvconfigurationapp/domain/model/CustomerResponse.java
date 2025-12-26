package edu.config.msvconfigurationapp.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustomerResponse class represents a response containing customer details.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String id;
    private String documento;
    private String compania;
    private String correo;
    private String contrasena;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
