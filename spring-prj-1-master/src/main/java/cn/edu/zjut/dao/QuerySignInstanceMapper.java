package cn.edu.zjut.dao;

import cn.edu.zjut.po.SignInstance;
import java.util.List;
public interface QuerySignInstanceMapper {
    List<SignInstance> getSignInstance(int signID)throws Exception;//查询某一打卡id下的详细打卡信息

}
