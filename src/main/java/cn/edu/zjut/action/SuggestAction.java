package cn.edu.zjut.action;

<<<<<<< HEAD
import cn.edu.zjut.po.Suggest;
import cn.edu.zjut.po.Teacher;
import cn.edu.zjut.service.ISuggestService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
public class SuggestAction {
    private Suggest suggest;
    private Map<String, Object> request, session;

    @Autowired
    ISuggestService suggestService = null;

    public void setSuggest(Suggest suggest) {
        this.suggest = suggest;
    }

    public Suggest getSuggest() {
        return suggest;
    }

    public void setSuggestService(ISuggestService suggestService) {
        this.suggestService = suggestService;
    }

    public ISuggestService getSuggestService() {
        return suggestService;
    }

    public String suggest() {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.getSession();
        try {
            if (suggest == null)
                System.out.println("no suggest");
            suggest.setTeacher((Teacher) session.get("teacher"));
            System.out.println(suggest.getSuggestion() + "111111");
            suggest.setDate(new Date());
            if (suggestService.suggestm(suggest)) {
                return "success";
            }
            return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
=======
import cn.edu.zjut.service.ISuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class SuggestAction {
    private String teaID;
    private String suggest;

    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Autowired
    private ISuggestService suggestService = null;

    /**
     * @Author 卢益铭
     * @Describe 调用suggestService的getStudentSuggest方法
     * 根据结果返回对应的字符串
     * @return
     */
    public String checkStudentSuggest(){
        try{
            if(suggestService.getStudentSuggest()){
                return "checkStudentSuggestSuccess";
            }else {
                return "checkStudentSuggestFail";
            }
        }catch (Exception e){
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 调用suggestService的getTeacherSuggest方法
     * 根据结果返回对应的字符串
     * @return
     */
    public String checkTeacherSuggest(){
        try{
            if(suggestService.getTeacherSuggest()){
                return "checkTeacherSuggestSuccess";
            }else {
                return "checkTeacherSuggestFail";
            }
        }catch (Exception e){
            return "login";
        }
    }

    /**
     * @Author 卢益铭
     * @Describe 传入教师的teaID和输入的建议suggest
     * 调用suggestService的insertTeacherSuggest方法
     * @return
     */
    public String insertTeacherSuggest(){
        try{
            if(suggestService.insertTeacherSuggest(teaID,suggest)){
                return "insertTeacherSuggestSuccess";
            }else{
                return "insertTeacherSuggestFail";
            }
        }catch (Exception e){
            return "login";
>>>>>>> origin/master
        }
    }
}
