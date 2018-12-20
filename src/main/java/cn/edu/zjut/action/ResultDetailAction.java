package cn.edu.zjut.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
//某个打卡下学生签到情况
@Controller
public class ResultDetailAction {
    private DailyResult dailyresult; //小打卡
    private Sign result; //大打卡
    private ResultDetail resultdetail;//打卡情况
    private List<ResultDetail> resultdetails=null;
    @Autowired
    private IDailyResultService dailyresultService;
    @Autowired
    private IResultService resultService;
    @Autowired
    private IResultDetailService resultdetailService;
    public IResultService getResultService() {
        return resultService;
    }
    @Resource
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public IDailyResultService getDailyresultService() {
        return dailyresultService;
    }
    @Resource
    public void setDailyresultService(IDailyResultService dailyresultService) {
        this.dailyresultService = dailyresultService;
    }
    public IResultDetailService getResultdetailService() {
        return resultdetailService;
    }
    @Resource
    public void setResultdetailService(IResultDetailService resultdetailService) {
        this.resultdetailService = resultdetailService;
    }
    public void setResultdetail(ResultDetail resultdetail)
    {
        this.resultdetail=resultdetail;
    }
    public ResultDetail getResultdetail()
    {
        return resultdetail;
    }
    public void setResultdetails(List<ResultDetail> resultdetails)
    {
        this.resultdetails=resultdetails;
    }
    public List<ResultDetail> getResultdetails()
    {
        return this.resultdetails;
    }
    public void setResult(Sign result)
    {
        this.result=result;
    }
    public Sign getResult()
    {
        return result;
    }
    public void setDailyresult(DailyResult dailyresult)
    {
        this.dailyresult=dailyresult;
    }
    public DailyResult getDailyresult()
    {
        return dailyresult;
    }


    public String getDetail(){//根据小打卡的id查找这个小打卡下的学生打卡情况
        System.out.println("now the getDetail    "+dailyresult.getSigninstance().getSignInstID());
        resultdetails=resultdetailService.getBySignInstance_id(dailyresult.getSigninstance().getSignInstID());//获取签到结果情况
       // System.out.println(resultdetails.get(0).getStudent_name());
        dailyresult=dailyresultService.getBySigninstance_id(dailyresult.getSigninstance().getSignInstID());
       // System.out.println(dailyresult.getSign_name());
        System.out.println("the fact and all"+dailyresult.getAll()+"***"+dailyresult.getFact());
		/*System.out.println(resultdetails.get(0).getSimilar()+"**"+resultdetails.get(0).getSignTime());
		result=resultService.getBySign_id(signinstance.getSignID());//获取签到项目
		signinstance=dailyresultService.getBySigninstance_id(signinstance.getSignInstID());//获取签到日期，时间
		//System.out.println(result.getSign_name());
		System.out.println(signinstance.getPlaceName());*/

        return "success-getDetail";
    }
    public String changeDetails(){//修改学生签到情况
        System.out.println("now the changeDetails*******");
        System.out.println(resultdetail.getStudentsign().getStatus());
        System.out.println(resultdetail.getStudentsign().getSignInstID());
        System.out.println(resultdetail.getStudentsign().getStuSignID());
        resultdetailService.update(resultdetail.getStudentsign().getStuSignID(),resultdetail.getStudentsign().getStatus());
        resultdetails=resultdetailService.getBySignInstance_id(resultdetail.getStudentsign().getSignInstID());
        dailyresult=dailyresultService.getBySigninstance_id(resultdetail.getStudentsign().getSignInstID());
        return "success-Details";
    }

    public String AutoPlay(){
        System.out.println("now the AutoPlay"+dailyresult.getSigninstance().getSignInstID());
        resultdetails=resultdetailService.getBySignInstance_id(dailyresult.getSigninstance().getSignInstID());//获取签到结果情况
        dailyresult=dailyresultService.getBySigninstance_id(dailyresult.getSigninstance().getSignInstID());
        System.out.println(dailyresult.getAll()+"***"+dailyresult.getFact());
		/*System.out.println(resultdetails.get(0).getSimilar()+"**"+resultdetails.get(0).getSignTime());
		result=resultService.getBySign_id(signinstance.getSignID());//获取签到项目
		signinstance=dailyresultService.getBySigninstance_id(signinstance.getSignInstID());//获取签到日期，时间
		//System.out.println(result.getSign_name());
		System.out.println(signinstance.getPlaceName());*/

        return "success-AutoPlay";
    }
}
