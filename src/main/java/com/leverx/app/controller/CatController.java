package com.leverx.app.controller;

import com.leverx.app.entity.request.cat.CatRequest;
import com.leverx.app.entity.response.cat.CatResponse;
import com.leverx.app.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService catService;

    @RequestMapping(value = "/{id}", method = GET)
    public CatResponse getCatById(@PathVariable(name = "id") long id) {
        return catService.find(id);
    }

    @RequestMapping(method = GET)
    public List<CatResponse> getAllCats() {
        return catService.findAll();
    }

    @RequestMapping(method = POST)
    public CatResponse createCat(@RequestBody CatRequest cat) {
        return catService.create(cat);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void deleteCat(@PathVariable(name = "id") long id) {
        catService.delete(id);
    }

    @RequestMapping(method = PUT)
    public CatResponse updateCat(@RequestBody CatRequest cat) {
        return catService.update(cat);
    }
}
