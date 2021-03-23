package com.leverx.app.service;

import com.leverx.app.entity.request.user.UserRequest;
import com.leverx.app.entity.response.user.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserResponse find(long id);

    List<UserResponse> findAll();

    Optional<UserResponse> findByName(String name);

    UserResponse create(UserRequest user);

    UserResponse update(UserRequest user);

    void delete(long id);
}
