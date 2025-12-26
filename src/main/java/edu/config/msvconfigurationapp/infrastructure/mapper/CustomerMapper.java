package edu.config.msvconfigurationapp.infrastructure.mapper;

import org.springframework.stereotype.Component;
import edu.config.msvconfigurationapp.domain.model.CustomerResponse;
import edu.config.msvconfigurationapp.infrastructure.adapter.dto.CustomerSpResult;

/**
 * CustomerMapper class is responsible for mapping between CustomerSpResult and CustomerResponse objects.
 *
 * @author Joseph Magallanes
 * @since 2025-12-26
 */
@Component
public class CustomerMapper {

    /**
     * Maps a CustomerSpResult to a CustomerResponse.
     *
     * @param customerSpResult the CustomerSpResult to map
     * @return the mapped CustomerResponse
     */
    public CustomerResponse toCustomerResponse(CustomerSpResult customerSpResult) {
        final CustomerResponse response = new CustomerResponse();
        response.setId(customerSpResult.getId());
        response.setDocumento(customerSpResult.getDocument());
        response.setCompania(customerSpResult.getCompanyName());
        response.setCorreo(customerSpResult.getEmail());
        response.setContrasena(customerSpResult.getPassword());
        response.setEstado(customerSpResult.getIsActive());
        response.setFechaCreacion(customerSpResult.getCreateDate());
        response.setFechaActualizacion(customerSpResult.getUpdateDate());
        return response;
    }
}
