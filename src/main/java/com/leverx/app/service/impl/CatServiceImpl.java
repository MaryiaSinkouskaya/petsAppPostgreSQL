package com.leverx.app.service.impl;

import com.leverx.app.entity.response.ResponseMapper;
import com.leverx.app.entity.response.cat.CatResponse;
import com.leverx.app.entity.request.cat.CatRequest;
import com.leverx.app.repository.CatRepository;
import com.leverx.app.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.leverx.app.entity.response.ResponseMapper.convert;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public CatResponse find(long id) {
        Optional<CatRequest> cat = catRepository.findById(id);
        return cat.map(ResponseMapper::convert).orElseGet(CatResponse::new);
    }

    @Override
    public List<CatResponse> findAll() {
        return catRepository.findAll().stream()
                .map(ResponseMapper::convert)
                .collect(toList());
    }

    @Override
    public CatResponse create(CatRequest cat) {
        return convert(catRepository.save(cat));
    }

    @Override
    public CatResponse update(CatRequest cat) {
        return convert(catRepository.save(cat));
    }

    @Override
    public void delete(long id) {
        catRepository.deleteById(id);
    }
}
