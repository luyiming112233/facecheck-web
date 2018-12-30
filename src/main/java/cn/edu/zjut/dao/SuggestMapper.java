package cn.edu.zjut.dao;

import cn.edu.zjut.po.Suggest;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
@Repository
public interface SuggestMapper {
    public void insertSuggest(Suggest suggest);

=======
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuggestMapper {

    /**
     * @Author 卢益铭
     * @Describe 返回所有的学生反馈
     * @return
     */
    public List<Suggest> listStudentSuggest();

    /**
     * @Author 卢益铭
     * @Describe 返回所有的教师反馈
     * @return
     */
    public List<Suggest> listTeacherSuggest();

    /**
     * @Author 卢益铭
     * @Describe 教师插入一条反馈
     * @param teacherID
     * @param suggest
     * @param time
     * @return
     */
    public int insertTeacherSuggest(@Param("teacherID") Integer teacherID,@Param("suggest") String suggest, @Param("mtime")String time);
>>>>>>> origin/master
}
