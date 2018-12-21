package cn.edu.zjut.service;

import cn.edu.zjut.dao.ResultDetailMapper;
import cn.edu.zjut.po.ResultDetail;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResultDetailService implements IResultDetailService{
    @Autowired
    private Map<String, Object> request, session;
    private ResultDetailMapper resultdetailmapper;
    public ResultDetailService()
    {
        System.out.println("create ResultDetailService");
    }
    @Resource
    public void setResultdetailmapper(ResultDetailMapper resultdetailmapper)
    {
        this.resultdetailmapper=resultdetailmapper;
    }


    @Override
    public List<ResultDetail> getBySignInstance_id(int signInstID) {//根据小打卡id获得该打卡的学生打卡情况
        System.out.println("resultdetailservice-getBySigninstance_id    "+signInstID);
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        List<ResultDetail> list=new ArrayList();
        try{
            list=(List<ResultDetail>)resultdetailmapper.selectBySigninstance_id(signInstID);
            request.put("list",list);
            System.out.println("service list.size()"+list.size());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void update(Integer StuSignID, Integer status) {//修改学生打卡情况
        System.out.println("resultdetailservice-update"+StuSignID+status);
        try{
            resultdetailmapper.update(StuSignID,status);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

    }

}
