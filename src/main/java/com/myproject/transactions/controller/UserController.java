package com.myproject.transactions.controller;

import com.myproject.transactions.dto.ResponseUserDTO;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.mapper.UserMapper;
import com.myproject.transactions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<ResponseUserDTO>> listAllUsers() {
        List<ResponseUserDTO> allUsersResponseDTO = userService.getAllUsers()
                .stream()
                .map(UserMapper.INSTANCE::fromEntityToResponseDTO)
                .toList();

        return ResponseEntity.ok(allUsersResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> findUserById(@PathVariable("id") Long id) throws Exception {
        ResponseUserDTO responseUserDTO = UserMapper.INSTANCE.fromEntityToResponseDTO(userService.getUserById(id));
        return ResponseEntity.ok(responseUserDTO);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
