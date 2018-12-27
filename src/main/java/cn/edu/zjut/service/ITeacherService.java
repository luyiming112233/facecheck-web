/**
 * JWW
 */
package cn.edu.zjut.service;


import cn.edu.zjut.po.Teacher;

public interface ITeacherService {
    /**
     * Jww:验证登录信息
     *
     * @param teacher
     * @return
     */
    public boolean login(Teacher teacher);

    /**
     * @Author 卢益铭
     * @Describe 插入一条学生信息
     * @param teacher
     * @return
     */
    public boolean insertTeacher(Teacher teacher);

    /**
     * @Author 卢益铭
     * @Describe 修改一个教师的信息
     * @param teacher
     * @return
     */
    public boolean updateTeacher(Teacher teacher);

    /**
     * @Author 卢益铭
     * @Describe 通过教师id删除一个教师的信息
     * @param teaID
     * @return
     */
    public boolean deleteTeacher(int teaID);

    /**
     * @Author 卢益铭
     * @Describe 查找所有的教师信息
     * @return
     */
    public boolean listAllTeacher();

    /**
     * @Author 卢益铭
     * @Describe 通过教师id查找教师
     * @param teaID
     * @return
     */
    public Teacher getTeacherByID(int teaID);

    /**
     * @Author 卢益铭
     * @Describe 通过不同的方式查找教师
     * @param teaMess
     * @param type
     * @return
     */
    public boolean searchTeacher(String teaMess, int type);
}
