package cn.edu.zjut.action;


import cn.edu.zjut.po.Sign;
import cn.edu.zjut.service.IQuerySignService;
import cn.edu.zjut.service.QuerySignService;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * quthor：黄丹
 * 用于进行查询显示sign表信息的action层
 * */
@Controller
public class QuerySignaction {
    IQuerySignService querySignService;
    List<Sign> signs;//使得页面获取到signs变量
    String query;//页面传来的单选框信息
    String input;//页面传来的输入框信息
    String val;//页面传来的有效性

    /*
     *set和get方法用于和jsp页面交互数据
     */
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Sign> getSigns() {
        return signs;
    }

    public void setSigns(List<Sign> signs) {
        this.signs = signs;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    /*
    得到所有的打卡信息
    */
    public String getAllSign() {
        try {
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSign();
            return "getAllSignsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getAllSignfail";
        }
    }

    /*根据id查询sign表的信息*/
    public String getAllSignByID() {
        try {
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByID(Integer.parseInt(input));
            return "querySignsuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }

    /*根据名字查询sign表的信息*/
    public String getAllSignByName() {
        try {
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByName(input);
            return "querySignsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }

    /*根据打卡创建时间查询sign表信息*/
    public String getAllSignByCreatetime() {
        try {
            //  SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
            //String date=sDateFormat.format(input);
            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByCreatetime(input);
            return "querySignbyDatesuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "querySignbyDatefail";
        }
    }

    /*根据教师id查询sign表信息*/
    public String getAllSignByTeaid() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignByTeaid(Integer.parseInt(input));
            return "querySignsuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }

    /*查询某日期后还有效的打卡项*/
    public String getAllSignValid() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignValid(input);
            return "querySignbyDatesuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignbyDatefail";
        }
    }

    /*根据打卡名模糊查询打卡信息*/
    public String getAllSignfuzzilybyName() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignfuzzilybyName(input);
            return "querySignfuzzilysuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignfuzzilyfail";
        }
    }

    /*根据部分日期信息来模糊查询*/
    public String getAllSignfuzzilybyCal() {
        try {

            querySignService = CtxUtil.getBean(QuerySignService.class);
            signs = querySignService.getAllSignfuzzilybyCal(input);
            return "querySignfuzzilysuccess";

        } catch (Exception e) {
            e.printStackTrace();
            return "querySignfuzzilyfail";
        }
    }

    /*用于基础查询打卡页面的action响应*/
    public String querySign() {
        try {
            if (query.equals("0")) {
                return getAllSignByName();
            } else if (query.equals("1")) {

                return getAllSignByID();
            } else if (query.equals("2")) {
                return getAllSignByTeaid();
            }
            return "querySignfail";
        } catch (Exception e) {
            return "querySignfail";

        }
    }

    /*用于根据日期查询打卡页面的action响应

     */
    public String querySignbyDate() {
        try {
            if (query.equals("0")) {
                return getAllSignByCreatetime();
            } else if (query.equals("1")) {

                return getAllSignValid();
            }
            return "querySignbyDatefail";
        } catch (Exception e) {
            return "querySignbyDatefail";
        }
    }

    /*
    用于模糊查询打卡页面的action响应
     */
    public String querySignfuzzily() {
        try {
            if (query.equals("0")) {
                return getAllSignfuzzilybyName();
            } else if (query.equals("1")) {

                return getAllSignfuzzilybyCal();
            }
            return "querySignfuzzilyfail";
        } catch (Exception e) {
            return "querySignfuzzilyfail";

        }

    }
}
