package cn.edu.zjut.dao;

import cn.edu.zjut.po.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherMapper {
    /*Jww函数换名*/
    public Teacher findById(int id);

    /**
     * 通过id查找教师
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Teacher getTeacherById(int id) throws Exception;

    /**
     * 返回所有教师的列表
     *
     * @return
     * @throws Exception
     */
    public List<Teacher> listAllTeacher() throws Exception;

    /**
     * 添加一条教师记录
     *
     * @param teacher
     * @return
     * @throws Exception
     */
    public int insertTeacher(Teacher teacher) throws Exception;

    /**
     * 根据教师id删除一条教师信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteTeacher(int id) throws Exception;

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     * @throws Exception
     */
    public int updateTeacher(Teacher teacher) throws Exception;

    /**
     * 通过姓名查找教师
     * @param name
     * @return
     * @throws Exception
     */
    public List<Teacher> listTeacherByName(String name) throws Exception;

}
