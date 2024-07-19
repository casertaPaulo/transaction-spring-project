package com.myproject.transactions.repository;

import com.myproject.transactions.entity.AnnouncementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, String> {
    Optional<AnnouncementEntity> findAnnouncementById(String id);
}
