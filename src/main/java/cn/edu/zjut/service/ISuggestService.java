package cn.edu.zjut.service;

import cn.edu.zjut.po.Suggest;

public interface ISuggestService {
    public boolean suggestm(Suggest suggest);
    public boolean insertTeacherSuggest(String teacherID,String suggest);
    public boolean getTeacherSuggest();
    public boolean getStudentSuggest();
}
