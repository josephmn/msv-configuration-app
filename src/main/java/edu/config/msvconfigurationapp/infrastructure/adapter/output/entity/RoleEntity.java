package edu.config.msvconfigurationapp.infrastructure.adapter.output.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
