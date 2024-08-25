package com.ms.user.Controller;

import com.ms.user.DTO.UserDTO;
import com.ms.user.Entity.User;
import com.ms.user.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
     private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO dto){
        User newUser = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
