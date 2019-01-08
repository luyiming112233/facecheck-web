package cn.edu.zjut.service;

import cn.edu.zjut.dao.GiftMapper;
import cn.edu.zjut.dao.StuGiftMapper;
import cn.edu.zjut.po.Gift;
import cn.edu.zjut.po.GiftChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GiftService implements IGiftService {
    @Autowired
    private GiftMapper giftMapper;
    @Autowired
    private StuGiftMapper stuGiftMapper;

    /**
     * 获取所有礼品信息
     *
     * @return
     * @Author 李璐瑶
     */
    @Override
    public List<Gift> getAllGift() {
        List<Gift> list = new ArrayList<>();
        try {
            list = giftMapper.selectAllGift();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除某个指定的礼品
     *
     * @param gift_id
     * @Author 李璐瑶
     */
    @Override
    public void deleteGift(int gift_id) {
        try {
            giftMapper.deleteById(gift_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得指定礼品的信息
     *
     * @param gift_id
     * @return
     * @Author 李璐瑶
     */
    @Override
    public Gift getGiftById(int gift_id) {
        Gift gift = new Gift();
        try {
            gift = giftMapper.selectGiftById(gift_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gift;
    }

    /**
     * 修改指定礼品的数量
     *
     * @param gift_id
     * @param gift_quantity
     * @Author 李璐瑶
     */
    @Override
    public void changeQuantity(int gift_id, int gift_quantity) {
        try {
            giftMapper.changeQuantity(gift_id, gift_quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
