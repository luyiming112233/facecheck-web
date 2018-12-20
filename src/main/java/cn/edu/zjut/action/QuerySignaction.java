package cn.edu.zjut.action;


import cn.edu.zjut.po.Sign;
import cn.edu.zjut.service.IQuerySignService;
import cn.edu.zjut.service.QuerySignService;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class QuerySignaction {
    IQuerySignService querySignService;
    List<Sign> signs;//使得页面获取到signs变量
    String query;//页面传来的单选框信息
    String input;//页面传来的输入框信息
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public List<Sign>  getSigns(){
        return signs;
    }
    public void setSigns(List<Sign> signs){
        this.signs=signs;
    }
    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    //得到所有的打卡信息
public String getAllSign(){
   try{
       querySignService =CtxUtil.getBean(QuerySignService.class);
       signs= querySignService.getAllSign();
       return "getAllSignsuccess";
   }
   catch (Exception e) {
      e.printStackTrace();
      return "getAllSignfail";
   }
}
    //根据id查询打卡
    public String getAllSignByID(){
        try{
            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByID(Integer.parseInt(input));
            return "querySignsuccess";

        }
        catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }
//根据名字查询打卡
    public String getAllSignByName(){
        try{
            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByName(input);
            return "querySignsuccess";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }
    //根据打卡创建时间查询打卡
    public  String getAllSignByCreatetime(){
        try{
          //  SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
           //String date=sDateFormat.format(input);
            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByCreatetime(input);
            return "getAllSignByCreatetimesuccess";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "getAllSignByCreatetimefail";
        }
    }
    //根据教师id查询打卡
    public  String getAllSignByTeaid(){
        try{

            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByTeaid(Integer.parseInt(input));
            return "querySignsuccess";

        }
        catch (Exception e) {
            e.printStackTrace();
            return "querySignfail";
        }
    }
public String querySign(){
        if(query.equals("0")){
        return getAllSignByName();
        }
        else if(query.equals("1")){

        return getAllSignByID();
        }
    else if(query.equals("2")){
        return getAllSignByTeaid();
        }
    return "querySignfail";
}
}
