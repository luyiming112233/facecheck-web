package cn.edu.zjut.app;

import cn.edu.zjut.action.TeacherAction;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.dao.TeacherMapper;
import cn.edu.zjut.po.Student;
import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        StudentMapper studentMapper =(StudentMapper)ctx.getBean("studentMapper");
        try {
            List<Student> studentList = studentMapper.listAllStudent();
            for(Student student:studentList){
                System.out.println(student.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
