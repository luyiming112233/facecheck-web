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
    Sign sign;//接收页面传来的sign

    public Sign getSign() {
        return sign;
    }
public void setSign(Sign sign){
        this.sign=sign;
}
    public List<Sign>  getSigns(){
        return signs;
    }
    public void setSigns(List<Sign> signs){
        this.signs=signs;
    }
//得到所有的打卡信息
public String getAllSign(){
   try{
       querySignService =CtxUtil.getBean(QuerySignService.class);
       signs= querySignService.getAllSign();
for(Sign s :signs){
    System.out.println(s.getSignID());
}
      return "getAllSignsuccess";
   }
   catch (Exception e) {
      e.printStackTrace();
      return "getAllSignfail";
   }
}
//根据名字查询打卡
    public String getAllSignByName(){
        try{
            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByName(sign.getName());

            return "getAllSignByNamesuccess";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "getAllSignByNamefail";
        }
    }
    //根据打卡创建时间查询打卡
    public  String getAllSignByCreatetime(){
        try{
            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd ");
           String date=sDateFormat.format(sign.getCreateTime());
            querySignService =CtxUtil.getBean(QuerySignService.class);
            signs= querySignService.getAllSignByCreatetime(date);
System.out.println("*********"+sign.getCreateTime());
            System.out.println("*********"+date);
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
            signs= querySignService.getAllSignByTeaid(sign.getTeaID());

            return "getAllSignByTeaidsuccess";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "getAllSignByTeaidfail";
        }
    }
}
