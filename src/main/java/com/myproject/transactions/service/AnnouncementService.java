package com.myproject.transactions.service;

import com.myproject.transactions.dto.RequestAnnouncementDTO;
import com.myproject.transactions.entity.AnnouncementEntity;
import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.enums.UserType;
import com.myproject.transactions.exception.announcement.AnnouncementNotFoundException;
import com.myproject.transactions.exception.announcement.SellerUserTypeException;
import com.myproject.transactions.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService implements Validate<AnnouncementEntity> {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public List<AnnouncementEntity> listAllAnnouncement() {
        return announcementRepository.findAll();
    }

    public AnnouncementEntity getAnnouncementById(String id) {
        return announcementRepository.findAnnouncementById(id).orElseThrow(() -> new AnnouncementNotFoundException(id));
    }

    public AnnouncementEntity createAnnouncement(RequestAnnouncementDTO requestAnnouncementDTO) throws Exception {
        UserEntity seller = userService.getUserById(requestAnnouncementDTO.sellerId());
        ProductEntity product = productService.findProductById(requestAnnouncementDTO.productId());

        AnnouncementEntity announcement = new AnnouncementEntity(seller, product, LocalDateTime.now());

        validate(announcement);

        return announcementRepository.save(announcement);
    }

    @Override
    public void validate(AnnouncementEntity announcement) {
        if (announcement.getSeller().getUserType() != UserType.SELLER) throw new SellerUserTypeException();
    }
}
