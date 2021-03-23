package com.leverx.app.service;

import com.leverx.app.entity.request.cat.CatRequest;
import com.leverx.app.entity.response.cat.CatResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    CatResponse find(long id);

    List<CatResponse> findAll();

    CatResponse create(CatRequest cat);

    void delete(long id);

    CatResponse update(CatRequest cat);
}
