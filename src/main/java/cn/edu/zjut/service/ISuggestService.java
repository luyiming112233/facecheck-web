package cn.edu.zjut.service;

public interface ISuggestService {
    /**
     * @Author 卢益铭
     * @Describe 调用mapper得到学生反馈，将学生反馈studentSuggestList放入request
     * @return
     */
    public boolean getStudentSuggest();

    /**
     * @Author 卢益铭
     * @Describe 调用mapper得到教师反馈，将教师反馈teacherSuggestList放入request
     * @return
     */
    public boolean getTeacherSuggest();

    /**
     * @Author 卢益铭
     * @Describe 传入teacherID和建议，将teacherID转化为Integer，得到系统时间，将信息存入教师建议表中
     * @param teacherID
     * @param suggest
     * @return
     */
    public boolean insertTeacherSuggest(String teacherID,String suggest);
}
