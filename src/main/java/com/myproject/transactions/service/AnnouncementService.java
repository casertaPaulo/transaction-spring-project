package com.myproject.transactions.service;

import com.myproject.transactions.dto.AnnouncementDTO;
import com.myproject.transactions.entity.AnnouncementEntity;
import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.repository.AnnouncementRepository;
import com.myproject.transactions.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public List<AnnouncementEntity> listAllAnnouncement() {
        return announcementRepository.findAll();
    }

    public AnnouncementEntity createAnnouncement(AnnouncementDTO announcementDTO) throws Exception {
        UserEntity seller = userService.getUserById(announcementDTO.getSellerId());
        ProductEntity product = productService.findProductById(announcementDTO.getProductId());

        return announcementRepository.save(new AnnouncementEntity(seller, product, LocalDateTime.now()));
    }

}
