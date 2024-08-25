package com.ms.user.Service;

import com.ms.user.DTO.UserDTO;
import com.ms.user.Entity.User;
import com.ms.user.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public User create(UserDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return userRepository.save(user);
    }
}
