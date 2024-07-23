package com.myproject.transactions.controller;

import com.myproject.transactions.dto.RequestAnnouncementDTO;
import com.myproject.transactions.entity.AnnouncementEntity;
import com.myproject.transactions.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<AnnouncementEntity>> listAllAnnouncements() {
        return ResponseEntity.ok(announcementService.listAllAnnouncement());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementEntity> findAnnouncementById(@PathVariable("id") String id) {
        return ResponseEntity.ok(announcementService.getAnnouncementById(id));
    }

    @PostMapping
    public ResponseEntity<AnnouncementEntity> createTransaction(@RequestBody RequestAnnouncementDTO requestAnnouncementDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(announcementService.createAnnouncement(requestAnnouncementDTO));
    }

}
