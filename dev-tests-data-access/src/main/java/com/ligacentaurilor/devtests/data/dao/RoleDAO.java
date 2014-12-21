package com.ligacentaurilor.devtests.data.dao;

import com.ligacentaurilor.devtests.data.entities.Role;
import com.ligacentaurilor.devtests.data.entities.RolePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface RoleDAO extends CrudRepository<Role, RolePK> {
}
