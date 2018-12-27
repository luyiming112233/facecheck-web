package cn.edu.zjut.action;

import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class TeacherMessageAction {
    private String teaID;
    private Teacher teacher;
    @Autowired
    private ITeacherService teacherService;

    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @Author 卢益铭
     * @Describe 传入教师的ID，返回教师信息
     * @return
     */
    public String getTeaMess() {
        try {
            teacher = (Teacher) teacherService.getTeacherByID(Integer.valueOf(teaID));
            if (teacher != null)
                return "getTeaMessSuccess";
            else
                return "getTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 传入学生ID，返回学生的信息
     * @return
     */
    public String updateTeaMess() {
        try {
            if (teacherService.updateTeacher(teacher))
                return "updateTeaMessSuccess";
            else
                return "updateTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 传入教师的ID，删除教师信息
     * @return
     */
    public String deleteTeaMess() {
        try {
            if (teacherService.deleteTeacher(Integer.valueOf(teaID)))
                return "deleteTeaMessSuccess";
            else
                return "deleteTeaMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

}