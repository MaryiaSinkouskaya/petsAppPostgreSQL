package com.leverx.app.controller;

import com.leverx.app.entity.request.user.UserRequest;
import com.leverx.app.entity.response.user.UserResponse;
import com.leverx.app.service.UserService;
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
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/{id}", method = GET)
    public UserResponse getUserById(@PathVariable(name = "id") long id) {
        return userService.find(id);
    }

    @RequestMapping(method = GET)
    public List<UserResponse> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(method = POST)
    public UserResponse createUser(@RequestBody UserRequest user) {
        return userService.create(user);
    }

    @RequestMapping(method = PUT)
    public UserResponse updateUser(@RequestBody UserRequest user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void deleteUser(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
}
