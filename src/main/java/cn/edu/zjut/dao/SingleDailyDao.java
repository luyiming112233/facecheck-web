package cn.edu.zjut.dao;

import cn.edu.zjut.po.SingleDaily;

public interface SingleDailyDao {
    SingleDaily getsinDailyByDID(String DailyID)throws Exception;//根据打卡id返回该打卡的详细信息
}
