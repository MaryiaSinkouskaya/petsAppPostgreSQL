package com.leverx.app.service.impl;

import com.leverx.app.entity.request.pet.PetRequest;
import com.leverx.app.entity.request.user.UserRequest;
import com.leverx.app.entity.response.ResponseMapper;
import com.leverx.app.entity.response.user.UserResponse;
import com.leverx.app.repository.PetRepository;
import com.leverx.app.repository.UserRepository;
import com.leverx.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.leverx.app.entity.response.ResponseMapper.convert;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public UserResponse create(UserRequest user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return convert(userRepository.save(user));
    }

    @Override
    public UserResponse find(long id) {
        Optional<UserRequest> user = userRepository.findById(id);
        return user.map(ResponseMapper::convert).orElseGet(UserResponse::new);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(ResponseMapper::convert)
                .collect(toList());
    }

    @Override
    public Optional<UserResponse> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public void delete(long id) {
        List<PetRequest> pets = petRepository.findAllByUserId(id);
        pets.forEach(pet -> pet.setUser(null));
        petRepository.saveAll(pets);
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(UserRequest user) {
        return convert(userRepository.save(user));
    }

}
