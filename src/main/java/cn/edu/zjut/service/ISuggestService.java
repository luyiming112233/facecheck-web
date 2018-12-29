package cn.edu.zjut.service;

public interface ISuggestService {
    public boolean getStudentSuggest();

    public boolean getTeacherSuggest();

    public boolean insertTeacherSuggest(String teacherID,String suggest);
}
