package cn.edu.zjut.service;

import cn.edu.zjut.dao.GiftMapper;
import cn.edu.zjut.po.Gift;
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

    @Override
    public void insertGift(Gift gift, File file) {
        System.out.println(file.getAbsolutePath());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("now giftService");
        String imgName = String.valueOf(gift.getGift_id());//自己写的一个获取字符串的方法作为图片名称
        //生成图片的存放在服务器的路径
        String path = "E:\\try\\imgs\\" + uuid + ".jpg";
        System.out.println(path);
        try {
            InputStream in = new FileInputStream(file);
            System.out.println("2");
            OutputStream out = new FileOutputStream(new File(path));
            if (!file.exists())
                file.mkdirs();
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            in.close();
            out.close();
            gift.setGift_img(path);
            System.out.println(gift.getGift_img());
            giftMapper.insertGift(gift);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGift(Gift gift, File file) {
        System.out.println("now the updateGift" + gift.getGift_id());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            if (file != null) {
                String path = gift.getGift_img();
                File f = new File(path);
                if (f.exists())
                    f.delete();
                else
                    f.mkdirs();
                InputStream in = new FileInputStream(file);
                OutputStream out = new FileOutputStream(new File(path));
                if (!file.exists())
                    file.mkdirs();
                byte[] b = new byte[1024];
                int len;
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                in.close();
                out.close();
                gift.setGift_img(path);
                System.out.println(gift.getGift_img());

            }
            giftMapper.updateGift(gift);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Gift> getAllGift() {
        System.out.println("the size is" + giftMapper.selectAllGift().size());
        List<Gift> list = new ArrayList<>();
        try {
            list = giftMapper.selectAllGift();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteGift(int gift_id) {
        System.out.println("now the deleteGift" + gift_id);
        try {
            giftMapper.deleteById(gift_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Gift getGiftById(int gift_id) {
        Gift gift = new Gift();
        System.out.println("now service" + gift_id);
        try {
            gift = giftMapper.selectGiftById(gift_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gift;
    }

    @Override
    public void changeQuantity(int gift_id, int gift_quantity) {
        System.out.println("now changeQuantity");
        try{
            giftMapper.changeQuantity(gift_id,gift_quantity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
