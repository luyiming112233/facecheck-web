package cn.edu.zjut.service;

import cn.edu.zjut.dao.AllDailyDao;
import cn.edu.zjut.dao.SingleDailyDao;
import cn.edu.zjut.po.AllDaily;
import cn.edu.zjut.po.SingleDaily;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DailyService implements IDailyService {
    @Resource
    AllDailyDao allDailyDao;
    @Resource
    SingleDailyDao singleDailyDao;

    @Override
    public List<AllDaily> getAllDaily() throws Exception {
        return allDailyDao.getAllDaily();
    }

    @Override
    public List<AllDaily> getAllDailyByArrp(String arrPerson) throws Exception {
        return allDailyDao.getAllDailyByArrp(arrPerson);
    }

    @Override
    public List<AllDaily> getAllDailyByCal(Date cal) throws Exception {
        return allDailyDao.getAllDailyByCal(cal);
    }

    @Override
    public List<AllDaily> getallDailyByDName(String DailyName) throws Exception {
        return allDailyDao.getallDailyByDName(DailyName);
    }

    @Override
    public AllDaily getallDailyByDID(String DailyID) throws Exception {
        return allDailyDao.getallDailyByDID(DailyID);
    }

    @Override
    public List<AllDaily> getallDailyByVal(boolean isValidate) throws Exception {
        return allDailyDao.getallDailyByVal(isValidate);
    }

    @Override
    public List<AllDaily> getallDailyByfuzzyCal(String cal) throws Exception {
        return allDailyDao.getallDailyByfuzzyCal(cal);
    }

    @Override
    public List<AllDaily> getallDailyByfuzzyArrp(String arrPerson) throws Exception {
        return allDailyDao.getallDailyByfuzzyArrp(arrPerson);
    }

    @Override
    public SingleDaily getsinDailyByDID(String DailyID) throws Exception {
        return singleDailyDao.getsinDailyByDID(DailyID);
    }
}
