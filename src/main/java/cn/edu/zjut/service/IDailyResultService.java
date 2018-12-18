package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.DailyResult;
import cn.edu.zjut.po.SignInstance;

public interface IDailyResultService {

    List<SignInstance> getBySign_id(int signID);
    DailyResult getBySigninstance_id(int signInstID);

}
