package edu.config.msvconfigurationapp.infrastructure.adapter.dto;

import java.time.LocalDateTime;

public record RoleSpResult(
    String Id,
    String Name,
    Boolean IsActive,
    LocalDateTime CreateDate,
    String NewCode,
    String Message
) {
}
