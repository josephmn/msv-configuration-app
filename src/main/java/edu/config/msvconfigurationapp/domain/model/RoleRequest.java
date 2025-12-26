package edu.config.msvconfigurationapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoleRequest class represents a request to create or update a role.
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private String nombre;
    private Boolean estado;
}
