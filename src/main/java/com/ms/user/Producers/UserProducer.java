package com.ms.user.Producers;

import com.ms.user.DTO.EmailDTO;
import com.ms.user.Entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User userEntity){
        EmailDTO emailDTO = new EmailDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                "Cadastro realizado com sucesso!",
                 userEntity.getName()+", Seja bem vindo a platforma de teste de email via RabbitMQ"
        );
        rabbitTemplate.convertAndSend("",routingKey,emailDTO);
    }
}
