package edu.config.msvconfigurationapp.infrastructure.mapper;

import edu.config.msvconfigurationapp.domain.model.RoleRequest;
import edu.config.msvconfigurationapp.domain.model.RoleResponse;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.RoleSpResult;
import edu.config.msvconfigurationapp.infrastructure.adapter.output.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleEntity toRoleEntity(RoleRequest request) {
        RoleEntity entity = new RoleEntity();
        entity.setId(request.getId());
        entity.setName(request.getNombre());
        entity.setIsActive(request.getEstado());
        return entity;
    }

//    public RoleResponse toRoleResponse(RoleEntity entity) {
//        RoleResponse response = new RoleResponse();
//        response.setId(entity.getId());
//        response.setNombre(entity.getName());
//        response.setEstado(entity.getIsActive());
//        return response;
//    }

    public RoleResponse toRoleResponse(RoleSpResult sp) {
        RoleResponse response = new RoleResponse();
        response.setId(sp.Id());
        response.setNombre(sp.Name());
        response.setEstado(sp.IsActive());
        response.setFechaCreacion(sp.CreateDate());
        return response;
    }
}
