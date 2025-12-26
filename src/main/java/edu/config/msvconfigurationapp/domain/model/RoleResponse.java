package edu.config.msvconfigurationapp.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoleResponse represents the response model for a role.
 * It contains information about the role such as its ID, name, status,
 * creation date, and last update date.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private String id;
    private String nombre;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
