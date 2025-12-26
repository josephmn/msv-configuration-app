package edu.config.msvconfigurationapp.infrastructure.adapter.output.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RoleEntity class represents the Role table in the database.
 * It is used to map the Role data from the database to the application.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Table("security.Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @Column("Id")
    private String id;
    @Column("Name")
    private String name;
    @Column("IsActive")
    private Boolean isActive;
}
