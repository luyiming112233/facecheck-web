package cn.edu.zjut.dao;

import cn.edu.zjut.po.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentMapper {
    /**
     * @Author 卢益铭
     * @Describe 新增学生
     * @param student
     * @return
     * @throws Exception
     */
    public int insertStudent(Student student) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 修改学生
     * @param student
     * @return
     * @throws Exception
     */
    public int updateStudent(Student student) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 刪除学生
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteStudent(int id) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 根据id查询学生信息
     * @param id
     * @return
     * @throws Exception
     */
    public Student getStudentById(int id) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 根据name查询学生信息
     * @param name
     * @return
     * @throws Exception
     */
    public List<Student> getStudentByName(String name) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 查询所有的学生信息
     * @return
     * @throws Exception
     */
    public List<Student> listAllStudent() throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 查询一个班级的学生信息
     * @param className
     * @return
     * @throws Exception
     */
    public List<Student> listStudentByClass(String className) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 查询一个专业的学生信息
     * @param departName
     * @return
     * @throws Exception
     */
    public List<Student> listStudentByDepart(String departName) throws Exception;

    /**
     *
     * @param stuField
     * @throws Exception
     */
    public void insertStudentExcel(ArrayList<Student> stuField) throws Exception;

    /**
     * @param stuField
     * @throws Exception
     */
    public void insertStudentFace(ArrayList<Student> stuField) throws Exception;

    /**
     * @param student
     * @throws Exception
     */
    public void insertOneStudentFace(Student student) throws Exception;

    /**
     * 加入Score数据库科
     * @param stuField
     * @throws Exception
     */
    public void insertStudentScore(ArrayList<Student> stuField)throws  Exception;

    /**
     * @Author 卢益铭
     * @Describe 在积分表中插入一个学生的基础信息
     * @param student
     * @throws Exception
     */
    public void insertOneStudentScore(Student student)throws  Exception;

    public String getOpenid(int stuID);
}
