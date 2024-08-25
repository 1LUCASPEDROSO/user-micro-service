package com.ms.user.DTO;

import java.util.UUID;

public record EmailDTO(UUID userId, String mailTo, String subject, String text) {
}
