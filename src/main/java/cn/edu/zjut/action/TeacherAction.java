package cn.edu.zjut.action;


import cn.edu.zjut.po.Sign;
import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.IResultService;
import cn.edu.zjut.service.ITeacherService;
import cn.edu.zjut.service.ResultService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Scope("prototype")
@Controller
public class TeacherAction {
    private String searchMess;
    private int searchType;
    private Teacher teacher;
    private List<Sign> results;
    private Map<String, Object> request, session;
    @Autowired
    private ITeacherService teacherService = null;
    @Autowired
    private IResultService resultService;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setResults(List<Sign> results) {
        this.results = results;
    }

    public List<Sign> getResults() {
        return results;
    }

    public String getSearchMess() {
        return searchMess;
    }

    public void setSearchMess(String searchMess) {
        this.searchMess = searchMess;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    public String login() {
        try {
            if (teacherService.login(teacher)) {
                ActionContext ctx = ActionContext.getContext();
                session = (Map) ctx.getSession();
                String id = ((Teacher) (session.get("teacher"))).getName();
                results = (List<Sign>) resultService.getByTeacher_id(teacher.getTeaID());
                return "success";
            } else
                return "fail";
        } catch (Exception e) {
            return "login";
        }
    }

    public String teacherAdd() {
        try {
            System.out.println(teacher.getName());
            if (teacher != null && teacherService.insertTeacher(teacher)) {
                return "teacherAddSuccess";
            } else {
                return "teacherAddFail";
            }
        } catch (Exception e) {
            return "login";
        }
    }

    public String getAllTeachers() {
        try {
            if (teacherService.listAllTeacher())
                return "getAllTeachersSuccess";
            else
                return "getAllTeachersFail";

        } catch (Exception e) {
            return "login";
        }
    }

    public String teacherSearch() {
        try {
            if (teacherService.searchTeacher(searchMess, searchType))
                return "searchTeacherSuccess";
            else
                return "searchTeacherFail";
        } catch (Exception e) {
            return "login";

        }
    }
}
