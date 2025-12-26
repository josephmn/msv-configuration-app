package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * CustomerSpResult class represents the result of a stored procedure for customers.
 * It extends MessageResult to include additional customer-specific fields.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
public class CustomerSpResult extends MessageResult {
    private String Id;
    private String Document;
    private String CompanyName;
    private String Email;
    private String Password;
    private Boolean IsActive;
    private LocalDateTime CreateDate;
    private LocalDateTime UpdateDate;

    /**
     * Constructor for CustomerSpResult.
     *
     * @param id          the customer ID
     * @param document    the customer document
     * @param companyName the company name
     * @param email       the customer email
     * @param password    the customer password
     * @param isActive    the active status of the customer
     * @param createDate  the creation date of the customer
     * @param updateDate  the last update date of the customer
     * @param status      the status message
     * @param message     the detailed message
     * @param <T>         the type parameter
     */
    public <T> CustomerSpResult(T id, T document, T companyName, T email, T password, T isActive, T createDate,
                                T updateDate, T status, T message) {
        super();
        this.Id = (String) id;
        this.Document = (String) document;
        this.CompanyName = (String) companyName;
        this.Email = (String) email;
        this.Password = (String) password;
        this.IsActive = (Boolean) isActive;
        this.CreateDate = (LocalDateTime) createDate;
        this.UpdateDate = (LocalDateTime) updateDate;
        super.setStatus((String) status);
        super.setMessage((String) message);
    }
}
