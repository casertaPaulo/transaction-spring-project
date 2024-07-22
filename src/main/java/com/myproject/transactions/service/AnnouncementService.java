package com.myproject.transactions.service;

import com.myproject.transactions.dto.AnnouncementDTO;
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

    public AnnouncementEntity getAnnouncementById(String id) {
        return announcementRepository.findAnnouncementById(id).orElseThrow(() -> new AnnouncementNotFoundException(id));
    }

    public AnnouncementEntity createAnnouncement(AnnouncementDTO announcementDTO) throws Exception {
        UserEntity seller = userService.getUserById(announcementDTO.getSellerId());
        ProductEntity product = productService.findProductById(announcementDTO.getProductId());

        validateAnnouncement(seller);

        return announcementRepository.save(new AnnouncementEntity(seller, product, LocalDateTime.now()));
    }

    private void validateAnnouncement(UserEntity seller) {
        if (seller.getUserType() != UserType.SELLER) throw new SellerUserTypeException();
    }

}
