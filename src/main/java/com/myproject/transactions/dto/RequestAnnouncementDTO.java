package com.myproject.transactions.dto;

import lombok.Getter;

@Getter
public record RequestAnnouncementDTO(
        Long sellerId,
        Long productId
) { }
