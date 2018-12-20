package cn.edu.zjut.action;

import cn.edu.zjut.po.Student;
import cn.edu.zjut.service.IStudentService;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Scope("prototype")
@Controller
public class StudentAction implements RequestAware {
    private Map request;
    private Student student;
    private String searchMess;
    private int searchType;

    @Autowired
    private IStudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setRequest(Map<String, Object> request) {
        this.request = request;
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

    public String studentAdd() {
        try {
            if (student != null) {
                studentService.insertStudent(student);
                request.put("tip", student.getName() + "信息添加成功！");
                return "studentAddSuccess";
            } else {
                request.put("tip", "添加失败！");
                return "studentAddFail";
            }
        }catch (Exception e){
            return "login";

        }
    }

    public String stuSearch() {
        try {
            boolean srarch = studentService.searchStudent(searchMess, searchType);
            if (srarch) {
                return "stuSearchSuccess";
            } else {
                student = null;
                return "stuSearchFail";
            }
        }catch ( Exception e){
            return "login";

        }
    }

    public String allStudents() {
        try {
            if (studentService.listAllStudent()) {
                return "allStudentsSuccess";
            } else {
                return "allStudentsFail";
            }
        }catch (Exception e){
            return "login";

        }
    }
}
