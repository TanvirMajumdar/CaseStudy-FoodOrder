package org.perscholas.foodorderwebapp.dao;

import org.perscholas.foodorderwebapp.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepo extends JpaRepository<Images, Long> {
}
