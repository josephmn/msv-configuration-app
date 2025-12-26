package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for role message result.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResult {
    private String Status;
    private String Message;
}
