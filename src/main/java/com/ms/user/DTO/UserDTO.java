package com.ms.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserDTO(UUID id, @NotBlank String name, @NotBlank @Email String email) {
}
