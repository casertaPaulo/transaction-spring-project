package com.myproject.transactions.controller;

import com.myproject.transactions.dto.AnnouncementDTO;
import com.myproject.transactions.dto.OrderDTO;
import com.myproject.transactions.entity.AnnouncementEntity;
import com.myproject.transactions.entity.OrderEntity;
import com.myproject.transactions.service.AnnouncementService;
import org.apache.coyote.Response;
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
        return new ResponseEntity<>(announcementService.listAllAnnouncement(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementEntity> findAnnouncementById(@PathVariable("id") String id) {
        return new ResponseEntity<>(announcementService.getAnnouncementById(id), HttpStatus.FOUND);
    }



    @PostMapping
    public ResponseEntity<AnnouncementEntity> createTransaction(@RequestBody AnnouncementDTO announcementDTO) throws Exception {
        return new ResponseEntity<>(announcementService.createAnnouncement(announcementDTO), HttpStatus.CREATED);
    }

}
