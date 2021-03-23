package com.leverx.app.service;

import com.leverx.app.entity.response.pet.PetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {

    PetResponse find(long id);

    List<PetResponse> findAll();

    List<PetResponse> findAllByUserId(long id);
}
