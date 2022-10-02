package com.jocelinlaroch08.inventorymanagement.service.impl;

import com.jocelinlaroch08.inventorymanagement.dto.UserDto;
import com.jocelinlaroch08.inventorymanagement.exception.EntityNotFoundException;
import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import com.jocelinlaroch08.inventorymanagement.exception.InvalidEntityException;
import com.jocelinlaroch08.inventorymanagement.model.User;
import com.jocelinlaroch08.inventorymanagement.repository.UserRepository;
import com.jocelinlaroch08.inventorymanagement.service.UserService;
import com.jocelinlaroch08.inventorymanagement.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);

        if(!errors.isEmpty()) {
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("User is not valid", ErrorCode.USER_NOT_VALID, errors);
        }

        User savedUser = userRepository.save(UserDto.toEntity(userDto));

        return UserDto.fromEntity(savedUser);
    }

    @Override
    public UserDto findById(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }

        Optional<User> user = userRepository.findById(id);

        UserDto userDto = UserDto.fromEntity(user.get());

        return Optional.of(userDto).orElseThrow(() -> new EntityNotFoundException("No user found", ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID is null");
            return;
        }
        userRepository.deleteById(id);
    }
}
