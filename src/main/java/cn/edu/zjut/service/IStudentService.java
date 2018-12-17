package cn.edu.zjut.service;

import cn.edu.zjut.po.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 增加一个学生信息
     *
     * @param student
     * @return
     */
    public boolean insertStudent(Student student);

    /**
     * 修改一个学生的信息
     *
     * @param student
     * @return
     */
    public boolean updateStudent(Student student);

    /**
     * 删除一个学生的信息
     *
     * @param stuID
     * @return
     */
    public boolean deleteStudent(int stuID);

    /**
     * 通过学号查找一个学生信息
     *
     * @param stuID
     * @return
     */
    public Student serachStudentByID(int stuID);

    /**
     * 查找所有学生的信息
     *
     * @return
     */
    public boolean listAllStudent();

    /**
     * 查找一个班级学生的信息
     *
     * @param className
     * @return
     */
    public List<Student> searchStudentByClass(String className);

    /**
     * 查找一个专业学生的信息
     *
     * @param departName
     * @return
     */
    public List<Student> searchStudentByDepart(String departName);

    /**
     * 根据输入的学生信息进行查找
     * 通过传入的student哪个属性不为空来判断根据什么查询
     *
     * @param stuMess
     * @param searchType
     * @return
     */
    public boolean searchStudent(String stuMess, int searchType);

    /**
     * 查看该学生的信息，并存入request
     *
     * @param id
     * @return
     */
    public boolean showStudent(int id);
}
