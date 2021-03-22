package com.leverx.app.service.impl;

import com.leverx.app.entity.response.ResponseMapper;
import com.leverx.app.entity.response.dog.DogResponse;
import com.leverx.app.entity.request.dog.DogRequest;
import com.leverx.app.repository.DogRepository;
import com.leverx.app.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.leverx.app.entity.response.ResponseMapper.convert;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public DogResponse find(long id) {
        Optional<DogRequest> dog = dogRepository.findById(id);
        return dog.map(ResponseMapper::convert).orElseGet(DogResponse::new);
    }

    @Override
    public DogResponse create(DogRequest dog) {
        return convert(dogRepository.save(dog));
    }

    @Override
    public List<DogResponse> findAll() {
        return dogRepository.findAll().stream()
                .map(ResponseMapper::convert)
                .collect(toList());
    }

    @Override
    public void delete(long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public DogResponse update(DogRequest dog) {
        return convert(dogRepository.save(dog));
    }
}
