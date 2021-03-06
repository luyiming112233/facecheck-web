package cn.edu.zjut.service;

import cn.edu.zjut.po.GiftChange;
import cn.edu.zjut.po.StudentGift;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface IStuGiftService {
    List<GiftChange> getStudentGift();

    int getListSize(int gift_id);

    void updateStuGift(Boolean result, int autoid);

    void deleteStuGift(int autoid);
}
