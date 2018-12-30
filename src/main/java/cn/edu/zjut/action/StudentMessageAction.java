package cn.edu.zjut.action;

import cn.edu.zjut.po.Student;
import cn.edu.zjut.service.IStudentService;
import cn.edu.zjut.service.ISuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class StudentMessageAction {
    private String stuID;
    private Student student;
    @Autowired
    private IStudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    /**
     * @Author 卢益铭
     * @Describe 传入学生ID，返回学生的信息
     * @return
     */
    public String getStuMess() {
        try {
            if (studentService.showStudent(Integer.parseInt(stuID)))
                return "getStuMessSuccess";
            else
                return "getStuMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 传入一个学生的新的信息，并更新
     * @return
     */
    public String updateStuMess() {
        try {
            if (studentService.updateStudent(student))
                return "updateStuMessSuccess";
            else
                return "updateStuMessFail";
        } catch (Exception e) {
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 传入一个学生ID，调用删除学生的方法
     * @return
     */
    public String deleteStuMess() {
        try {
            if (studentService.deleteStudent(Integer.valueOf(stuID)))
                return "deleteStuMessSuccess";
            else
                return "deleteStuMessFail";
        } catch (Exception e) {
            return "login";

        }
    }
}
