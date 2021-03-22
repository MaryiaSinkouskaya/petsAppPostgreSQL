package com.leverx.app.repository;

import com.leverx.app.dto.user.UserDto;
import com.leverx.app.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDto> findByName(String name);
}
