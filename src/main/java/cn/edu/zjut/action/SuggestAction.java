package cn.edu.zjut.action;

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
        }
    }
}
