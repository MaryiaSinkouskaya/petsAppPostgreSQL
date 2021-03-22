package com.leverx.app.service.impl;

import com.leverx.app.entity.response.ResponseMapper;
import com.leverx.app.entity.response.pet.PetResponse;
import com.leverx.app.entity.request.pet.PetRequest;
import com.leverx.app.repository.PetRepository;
import com.leverx.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public PetResponse find(long id) {
        Optional<PetRequest> pet = petRepository.findById(id);
        return pet.map(ResponseMapper::convert).orElseGet(PetResponse::new);
    }

    @Override
    public List<PetResponse> findAll() {
        return petRepository.findAll().stream()
                .map(ResponseMapper::convert)
                .collect(toList());
    }

    @Override
    public List<PetResponse> findAllByUserId(long id) {
        return petRepository.findAllByUserId(id).stream()
                .map(ResponseMapper::convert)
                .collect(toList());
    }

}
