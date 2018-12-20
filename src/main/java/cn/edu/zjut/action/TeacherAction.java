package cn.edu.zjut.action;


import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Scope("prototype")
@Controller
public class TeacherAction {
    private String searchMess;
    private int searchType;
    private Teacher teacher;
    @Autowired
    private ITeacherService teacherService = null;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
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

    public String login() {
        try{
        if (teacherService.login(teacher)) {
            return "success";
        } else
            return "fail";
    }catch (Exception e ) {
            return "login";
        }
        }

    public String teacherAdd() {
        try{
        System.out.println(teacher.getName());
        if (teacher != null && teacherService.insertTeacher(teacher)) {
            return "teacherAddSuccess";
        } else {
            return "teacherAddFail";
        }
    }catch (Exception e ) {
            return "login";
        }
        }

    public String getAllTeachers() {
        try{
        if (teacherService.listAllTeacher())
            return "getAllTeachersSuccess";
        else
            return "getAllTeachersFail";

    }catch (Exception e) {
            return "login";
        }
        }

    public String teacherSearch() {
        try {
            if (teacherService.searchTeacher(searchMess, searchType))
                return "searchTeacherSuccess";
            else
                return "searchTeacherFail";
        }catch (Exception e){
            return "login";

        }
    }
}
