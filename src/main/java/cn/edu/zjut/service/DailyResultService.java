package cn.edu.zjut.service;

import cn.edu.zjut.dao.DailyResultMapper;
import cn.edu.zjut.po.DailyResult;
import cn.edu.zjut.po.SignInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DailyResultService implements IDailyResultService {
    @Autowired
    private DailyResultMapper dailyresultmapper;
    public DailyResultService()
    {
        System.out.println("create DailyResultService");
    }
    public void setDailyresultmapper(DailyResultMapper dailyresultmapper)
    {
        this.dailyresultmapper=dailyresultmapper;
    }


    @Override
    public List<SignInstance> getBySign_id(String signID) {//根据大打卡的id得到小打卡列表
        System.out.println("dailyresultservice-getBySign_id"+signID);
        List<SignInstance> list=new ArrayList();
        try{
            list=(List<SignInstance>)dailyresultmapper.selectBySign_id(signID);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
        // TODO Auto-generated method stub
    }
    @Override
    public DailyResult getBySigninstance_id(int signInstID) {//根据小打卡id查找某个具体的 小打卡
        System.out.println("dailyresultservice-getBySigninstance_id");
        DailyResult dailyresult=new DailyResult();
        SignInstance signinstance=null;
        try{
            signinstance=dailyresultmapper.selectBySigninstance_id(signInstID);
            int allpeople=dailyresultmapper.selectNumberofAll(signInstID);
            int fact=dailyresultmapper.selectNumberofFact(signInstID);
            dailyresult.setAll(allpeople);
            dailyresult.setFact(fact);
            dailyresult.setSign_name(dailyresultmapper.selectSign_name(signInstID));
            dailyresult.setSigninstance(signinstance);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return dailyresult;
    }

}
