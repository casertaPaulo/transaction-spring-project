package com.myproject.transactions.dto;

import lombok.Getter;


public record RequestOrderDTO (
        String announcementId,
        Long buyerId
) { }
