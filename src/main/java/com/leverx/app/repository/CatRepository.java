package com.leverx.app.repository;

import com.leverx.app.entity.request.cat.CatRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<CatRequest, Long> {
}
