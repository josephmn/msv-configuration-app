package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * RoleSpResult class represents the result of a stored procedure for roles.
 * It extends RoleMessageResult to include additional role-specific fields.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
public class RoleSpResult extends RoleMessageResult {
    private String Id;
    private String Name;
    private Boolean IsActive;
    private LocalDateTime CreateDate;
    private LocalDateTime UpdateDate;

    /**
     * Constructor for RoleSpResult.
     *
     * @param id         the role ID
     * @param name       the role name
     * @param isActive   the active status of the role
     * @param createDate the creation date of the role
     * @param updateDate the last update date of the role
     * @param status     the status message
     * @param message    the detailed message
     * @param <T>        the type parameter
     */
    public <T> RoleSpResult(T id, T name, T isActive, T createDate, T updateDate, T status, T message) {
        super();
        this.Id = (String) id;
        this.Name = (String) name;
        this.IsActive = (Boolean) isActive;
        this.CreateDate = (LocalDateTime) createDate;
        this.UpdateDate = (LocalDateTime) updateDate;
        super.setStatus((String) status);
        super.setMessage((String) message);
    }
}
