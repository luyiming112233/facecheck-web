/**
 * JWW
 */
package cn.edu.zjut.service;


import cn.edu.zjut.po.Teacher;

import java.util.List;

public interface ITeacherService {
    /**
     * Jww:验证登录信息
     *
     * @param teacher
     * @return
     */
    public boolean login(Teacher teacher);

    /**
     * 插入一条学生信息
     *
     * @param teacher
     * @return
     */
    public boolean insertTeacher(Teacher teacher);

    /**
     * 修改一个教师的信息
     *
     * @param teacher
     * @return
     */
    public boolean updateTeacher(Teacher teacher);

    /**
     * 通过教师id删除一个教师的信息
     *
     * @param teaID
     * @return
     */
    public boolean deleteTeacher(int teaID);

    /**
     * 查找所有的教师信息
     *
     * @return
     */
    public boolean listAllTeacher();

    /**
     * 通过教师id查找教师
     *
     * @param teaID
     * @return
     */
    public Teacher getTeacherByID(int teaID);

    /**
     * 教师查找
     *
     * @param teacher
     * @return
     */
    public boolean searchTeacherByTeacher(Teacher teacher);
}
