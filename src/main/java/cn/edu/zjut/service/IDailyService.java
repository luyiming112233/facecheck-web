package cn.edu.zjut.service;

import cn.edu.zjut.po.AllDaily;
import cn.edu.zjut.po.SingleDaily;

import java.util.Date;
import java.util.List;

public interface IDailyService {
    List<AllDaily> getAllDaily() throws Exception;//查询所有打卡记录

    List<AllDaily> getAllDailyByArrp(String arrPerson) throws Exception;//查询某个发布人发布的所有打卡

    List<AllDaily> getAllDailyByCal(Date cal) throws Exception;//查询某一日期下的所有打卡记录

    List<AllDaily> getallDailyByDName(String DailyName) throws Exception;//查询某一打卡名下的所有打卡

    AllDaily getallDailyByDID(String DailyID) throws Exception;//根据打卡id查询打卡

    List<AllDaily> getallDailyByVal(boolean isValidate) throws Exception;//根据该打卡是否还有效来查询

    List<AllDaily> getallDailyByfuzzyCal(String cal) throws Exception;//模糊查询某一个日期下的打卡

    List<AllDaily> getallDailyByfuzzyArrp(String arrPerson) throws Exception;//模糊查询某个打卡人发布的打卡

    SingleDaily getsinDailyByDID(String DailyID) throws Exception;//根据打卡id返回该打卡的详细信息

}
