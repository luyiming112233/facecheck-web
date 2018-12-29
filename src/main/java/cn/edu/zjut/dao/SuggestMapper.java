package cn.edu.zjut.dao;

import cn.edu.zjut.po.Suggest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuggestMapper {

    public List<Suggest> listStudentSuggest();

    public List<Suggest> listTeacherSuggest();

    public int insertTeacherSuggest(@Param("teacherID") Integer teacherID,@Param("suggest") String suggest, @Param("mtime")String time);
}
