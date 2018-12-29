package cn.edu.zjut.service;

import cn.edu.zjut.dao.StuGiftMapper;
import cn.edu.zjut.po.GiftChange;
import cn.edu.zjut.po.StudentGift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuGiftService implements IStuGiftService {
    @Autowired
    private StuGiftMapper stuGiftMapper;

    public StuGiftMapper getStuGiftMapper() {
        return stuGiftMapper;
    }

    public void setStuGiftMapper(StuGiftMapper stuGiftMapper) {
        this.stuGiftMapper = stuGiftMapper;
    }

    @Override
    public List<GiftChange> getStudentGift() {
        System.out.println("now getStudentGift");
        List<GiftChange> list=new ArrayList<>();
        try{
           list=stuGiftMapper.selectStudentGift();
           System.out.println("now the service"+list.size());
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateStuGift(Boolean result,int autoid) {
        try {
            System.out.println("now updateStuGift");
            stuGiftMapper.updateStudentGift(result,autoid);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStuGift(int autoid) {
        try{
            stuGiftMapper.deleteById(autoid);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(GiftChange g) {
        try{
            System.out.println("now the insert");
            stuGiftMapper.insert(g);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
