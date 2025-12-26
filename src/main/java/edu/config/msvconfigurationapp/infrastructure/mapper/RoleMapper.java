package edu.config.msvconfigurationapp.infrastructure.mapper;

import org.springframework.stereotype.Component;
import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.RoleSpResult;
import edu.config.msvconfigurationapp.infrastructure.adapter.output.entity.RoleEntity;

/**
 * RoleMapper class is responsible for mapping between RoleRequest, RoleResponse,
 * RoleEntity, and RoleSpResult objects.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Component
public class RoleMapper {

    /**
     * Maps a RoleRequest object to a RoleEntity object.
     *
     * @param request the RoleRequest object
     * @return the mapped RoleEntity object
     */
    public RoleEntity toRoleEntity(RoleRequest request) {
        final RoleEntity entity = new RoleEntity();
        entity.setName(request.getNombre());
        entity.setIsActive(request.getEstado());
        return entity;
    }

    /**
     * Maps a RoleSpResult object to a RoleResponse object.
     *
     * @param roleSpResult the RoleSpResult object
     * @return the mapped RoleResponse object
     */
    public RoleResponse toRoleResponse(RoleSpResult roleSpResult) {
        final RoleResponse response = new RoleResponse();
        response.setId(roleSpResult.getId());
        response.setNombre(roleSpResult.getName());
        response.setEstado(roleSpResult.getIsActive());
        response.setFechaCreacion(roleSpResult.getCreateDate());
        response.setFechaActualizacion(roleSpResult.getUpdateDate());
        return response;
    }
}
