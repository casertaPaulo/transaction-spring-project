package com.myproject.transactions.dto;

import lombok.Getter;

public record RequestAnnouncementDTO(
        Long sellerId,
        Long productId
) { }
