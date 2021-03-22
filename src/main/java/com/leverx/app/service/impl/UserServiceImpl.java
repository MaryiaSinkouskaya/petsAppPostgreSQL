package com.leverx.app.service.impl;

import com.leverx.app.dto.DtoMapper;
import com.leverx.app.dto.user.UserDto;
import com.leverx.app.entity.pet.Pet;
import com.leverx.app.entity.user.User;
import com.leverx.app.repository.PetRepository;
import com.leverx.app.repository.UserRepository;
import com.leverx.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public User create(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDto find(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(DtoMapper::convert).orElseGet(UserDto::new);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(DtoMapper::convert)
                .collect(toList());
    }

    @Override
    public Optional<UserDto> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public void delete(long id) {
        List<Pet> pets = petRepository.findAllByUserId(id);
        pets.forEach(pet -> pet.setUser(null));
        petRepository.saveAll(pets);
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

}
