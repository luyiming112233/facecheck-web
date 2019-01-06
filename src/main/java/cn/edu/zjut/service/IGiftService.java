package cn.edu.zjut.service;

import cn.edu.zjut.po.Gift;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IGiftService {
    List<Gift> getAllGift();
    void deleteGift(int gift_id);
    Gift getGiftById(int gift_id);
    void changeQuantity(int gift_id,int gift_quantity);
}
