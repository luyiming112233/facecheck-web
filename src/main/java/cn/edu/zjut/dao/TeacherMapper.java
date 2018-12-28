package cn.edu.zjut.dao;

import cn.edu.zjut.po.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    public Teacher findById(int id);

    /**
     * @Author 卢益铭
     * @Describe 通过id查找教师
     * @param id
     * @return
     * @throws Exception
     */
    public Teacher getTeacherById(int id) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 返回所有教师的列表
     * @return
     * @throws Exception
     */
    public List<Teacher> listAllTeacher() throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 添加一条教师记录
     * @param teacher
     * @return
     * @throws Exception
     */
    public int insertTeacher(Teacher teacher) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 根据教师id删除一条教师信息
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteTeacher(int id) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 更新教师信息
     * @param teacher
     * @return
     * @throws Exception
     */
    public int updateTeacher(Teacher teacher) throws Exception;

    /**
     * @Author 卢益铭
     * @Describe 通过姓名查找教师
     * @param name
     * @return
     * @throws Exception
     */
    public List<Teacher> listTeacherByName(String name) throws Exception;



}
