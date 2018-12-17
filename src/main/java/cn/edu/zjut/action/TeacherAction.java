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
    private Teacher teacher;
    @Autowired
    private ITeacherService teacherService = null;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String login() {
        if (teacherService.login(teacher)) {
            return "success";
        } else
            return "fail";
    }

    public String teacherAdd() {
        System.out.println(teacher.getName());
        if (teacher != null && teacherService.insertTeacher(teacher)) {
            return "teacherAddSuccess";
        } else {
            return "teacherAddFail";
        }
    }

    public String getAllTeachers() {
        if (teacherService.listAllTeacher())
            return "getAllTeachersSuccess";
        else
            return "getAllTeachersFail";

    }

    public String teacherSearch(){
        if(teacherService.searchTeacherByTeacher(teacher))
            return "searchTeacherSuccess";
        else
            return "searchTeacherFail";
    }
}
