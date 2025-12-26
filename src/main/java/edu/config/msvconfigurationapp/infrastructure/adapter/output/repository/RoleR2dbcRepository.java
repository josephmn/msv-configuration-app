package edu.config.msvconfigurationapp.infrastructure.adapter.output.repository;

import edu.config.msvconfigurationapp.infrastructure.adapter.output.entity.RoleEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleR2dbcRepository extends ReactiveCrudRepository<RoleEntity, String> {
}
