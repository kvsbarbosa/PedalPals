package com.kvsb.pp.repositories;

import com.kvsb.pp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
