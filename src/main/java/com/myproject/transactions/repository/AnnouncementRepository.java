package com.myproject.transactions.repository;

import com.myproject.transactions.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, String> {
}
