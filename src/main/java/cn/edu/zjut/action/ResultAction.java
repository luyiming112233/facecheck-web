package cn.edu.zjut.action;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.zjut.po.*;
import cn.edu.zjut.service.*;
//大打卡有关
@Controller
public class ResultAction extends ActionSupport {
    private Sign result; //大打卡信息
    private List<Sign> results;//大打卡信息列表
    private Teacher teacher;
    private String message;
    private int searchType;
    private Map<String, Object> request, session;

    @Autowired
    //@Resource(name="resultService")
    private IResultService resultService;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public void setResult(Sign result) {
        this.result = result;
    }

    public Sign getResult() {
        return result;
    }

    public void setResults(List<Sign> results) {
        this.results = results;
    }

    public List<Sign> getResults() {
        return results;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public IResultService getResultService() {
        return resultService;
    }

    @Resource

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    //查看所有签到
    public String lookAllSign()//根据teacher_id查看该老师发布的所有签到信息
    {
        try {
            ActionContext ctx = ActionContext.getContext();
            session = (Map) ctx.getSession();
            teacher = ((Teacher) (session.get("teacher")));
            System.out.println(teacher.getTeaID() + "***********");
            results = (List<Sign>) resultService.getByTeacher_id(teacher.getTeaID());
            // System.out.println("*************"+results.get(0).getSignID()+results.get(0).getTeaID());
            //  System.out.println("the time is"+results.get(0).getCreateTime());
            return "success-lookAll";
        } catch (Exception e) {
            return "fail";
        }
    }

    //按签到名查找
    public String getByName()//根据签到名称查找       teacher_id和sign_name查看该老师发布的信息
    {
        try {
            System.out.println("now the ResultAction-ByName" + result.getName());
            results = (List<Sign>) resultService.getBySign_name(result.getName(), teacher.getTeaID());
            return "success-Byname";
        } catch (Exception e) {
            return "fail";
        }
    }

    //按创建时间查找
    public String getByTime()//根据签到发布时间       teacher_id和createtime查看该老师发布的所有签到信息
    {
        try {
            System.out.println("now the ResultAction-ByTime" + result.getCreateTime());
            results = (List<Sign>) resultService.getByCreatetime(String.valueOf(result.getCreateTime()), teacher.getTeaID());
            return "success-Bytime";
        } catch (Exception e) {
            return "fail";
        }
    }

    public String findSign() {
        try {
            System.out.println("now the find message:" + message + "searchType" + searchType + "teaID" + teacher.getTeaID());
            results = (List<Sign>) resultService.find(message, searchType, teacher.getTeaID());
            return "success-find";
        } catch (Exception e) {
            return "fail";
        }
    }
}
