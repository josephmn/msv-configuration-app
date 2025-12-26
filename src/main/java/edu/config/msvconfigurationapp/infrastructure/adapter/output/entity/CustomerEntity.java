package edu.config.msvconfigurationapp.infrastructure.adapter.output.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustomerEntity class represents the Customer table in the database.
 * It is used to map the Customer data from the database to the application.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Table("platform.Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column("Id")
    private String id;
    @Column("Document")
    private String document;
    @Column("CompanyName")
    private String companyName;
    @Column("Email")
    private String email;
    @Column("Password")
    private String password;
    @Column("IsActive")
    private Boolean isActive;
}
