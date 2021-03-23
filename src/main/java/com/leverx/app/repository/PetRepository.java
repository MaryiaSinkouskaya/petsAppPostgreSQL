package com.leverx.app.repository;

import com.leverx.app.entity.request.pet.PetRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetRequest, Long> {
    List<PetRequest> findAllByUserId(long id);
}
