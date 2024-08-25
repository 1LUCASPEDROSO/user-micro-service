package com.ms.user.Service;

import com.ms.user.DTO.UserDTO;
import com.ms.user.Entity.User;
import com.ms.user.Producers.UserProducer;
import com.ms.user.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }
    @Transactional // garante um rollback caso de algum erro em alguma etapa
    public User create(UserDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        User userEntity = userRepository.save(user);
        userProducer.publishMessageEmail(userEntity);
        return userEntity;
    }
}
