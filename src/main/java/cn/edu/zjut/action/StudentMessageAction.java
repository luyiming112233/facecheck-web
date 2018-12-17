package cn.edu.zjut.action;

import cn.edu.zjut.po.Student;
import cn.edu.zjut.service.IStudentService;
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

    public String getStuMess(){
        if(studentService.showStudent(Integer.parseInt(stuID)))
            return "getStuMessSuccess";
        else
            return "getStuMessFail";
    }

    public String updateStuMess(){
        if(studentService.updateStudent(student))
            return "updateStuMessSuccess";
        else
            return "updateStuMessFail";
    }

    public String deleteStuMess(){
        if(studentService.deleteStudent(Integer.valueOf(stuID)))
            return "deleteStuMessSuccess";
        else
            return "deleteStuMessFail";
    }
}
