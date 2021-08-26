package org.perscholas.foodorderwebapp.dao;

import org.perscholas.foodorderwebapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
