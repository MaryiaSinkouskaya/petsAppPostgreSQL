package com.leverx.app.service;

import com.leverx.app.dto.user.UserDto;
import com.leverx.app.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    UserDto find(long id);

    List<UserDto> findAll();

    Optional<UserDto> findByName(String name);

    User create(User user);

    User update(User user);

    void delete(long id);
}
