package cn.edu.zjut.action;

import cn.edu.zjut.po.SignInstance;
import cn.edu.zjut.service.IQuerySignInstanceService;
import cn.edu.zjut.service.QuerySignInstanceService;

import java.util.List;

public class QuerySignInstanceaction {
    IQuerySignInstanceService querySignInstanceService;
    List<SignInstance> signInstances;//将信息传到页面去
    int signID;//接收页面传来的打卡id
    public List<SignInstance> getSignInstances() {
        return signInstances;
    }
    public void setSignInstances(List<SignInstance> signInstances) {
        this.signInstances = signInstances;
    }
    public int getSignID() {
        return signID;
    }
    public void setSignID(int signID) {
        this.signID = signID;
    }
public String getSignInstance(){
    try{
        querySignInstanceService=CtxUtil.getBean(QuerySignInstanceService.class);
        System.out.println(signID);
        signInstances=querySignInstanceService.getSignInstance(signID);
for(SignInstance signInstance:signInstances)
    System.out.println(signInstance.getEndTime());
        return "getSignInstancesuccess";
    }
    catch (Exception e) {
        e.printStackTrace();
        return "getSignInstancefail";
    }
}

}
