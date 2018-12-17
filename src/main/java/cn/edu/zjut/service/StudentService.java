package cn.edu.zjut.service;

import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Student;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements IStudentService {
    private Map<String, Object> request,session;

    @Autowired
    StudentMapper studentMapper = null;

    @Override
    public boolean insertStudent(Student student) {
        try {
            studentMapper.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        request.put("student",student);
        try {
            studentMapper.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteStudent(int stuID) {
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        try {
            studentMapper.deleteStudent(stuID);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        List<Student> studentList = (List<Student>) session.get("studentList");
        for(Student student:studentList){
            if(student.getStuID()==stuID) {
                studentList.remove(student);
                break;
            }
        }
        session.put("studentList",studentList);
        return true;
    }

    @Override
    public Student serachStudentByID(int stuID) {
        try {
            Student student = studentMapper.getStudentById(stuID);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> searchStudentByClass(String className) {
        try {
            List<Student> studentList = studentMapper.listStudentByClass(className);
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> searchStudentByDepart(String departName) {
        try {
            List<Student> studentList = studentMapper.listStudentByDepart(departName);
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean searchStudent(String stuMess, int type) {
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Student> studentList = null;
        // 0:按学号查询；1：按姓名查询；2：按班级查询；3：按专业查询
        try {
            switch (type) {
                case 0:
                    Student student = studentMapper.getStudentById(Integer.parseInt(stuMess));
                    studentList = new ArrayList<Student>();
                    studentList.add(student);

                    break;
                case 1:
                    studentList = studentMapper.getStudentByName(stuMess);
                    break;
                case 2:
                    studentList = studentMapper.listStudentByClass(stuMess);
                    break;
                case 3:
                    studentList = studentMapper.listStudentByDepart(stuMess);
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        if (studentList != null) {
            session.put("studentList", studentList);
            return true;
        }
        return false;
    }

    @Override
    public boolean listAllStudent() {
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Student> studentList = null;
        try {
            studentList = studentMapper.listAllStudent();
            session.put("studentList", studentList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean showStudent(int stuID){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try {
            Student student = studentMapper.getStudentById(stuID);
            request.put("student",student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
