package com.myproject.transactions.dto;

import lombok.Getter;

@Getter
public record RequestOrderDTO (
        String announcementId,
        Long buyerId
) { }
