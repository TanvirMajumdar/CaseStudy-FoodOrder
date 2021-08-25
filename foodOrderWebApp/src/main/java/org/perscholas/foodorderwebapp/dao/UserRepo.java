package org.perscholas.foodorderwebapp.dao;

import org.perscholas.foodorderwebapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
