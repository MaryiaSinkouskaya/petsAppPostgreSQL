package com.leverx.app.repository;

import com.leverx.app.entity.request.dog.DogRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<DogRequest, Long> {
}
