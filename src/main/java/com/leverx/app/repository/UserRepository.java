package com.leverx.app.repository;

import com.leverx.app.entity.request.user.UserRequest;
import com.leverx.app.entity.response.user.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRequest, Long> {
    Optional<UserResponse> findByName(String name);
}
