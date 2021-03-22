package com.leverx.app.service;

import com.leverx.app.entity.response.dog.DogResponse;
import com.leverx.app.entity.request.dog.DogRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {

    DogResponse find(long id);

    List<DogResponse> findAll();

    DogResponse create(DogRequest dog);

    void delete(long id);

    DogResponse update(DogRequest dog);
}
