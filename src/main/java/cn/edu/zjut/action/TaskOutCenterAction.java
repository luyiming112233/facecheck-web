package cn.edu.zjut.action;

import cn.edu.zjut.po.*;
import cn.edu.zjut.service.ISignInstanceService;
import cn.edu.zjut.service.IStudentService;
import cn.edu.zjut.service.ITaskService;
import cn.edu.zjut.service.SignInstanceService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
public class TaskOutCenterAction {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private ISignInstanceService signInstanceService;

    @Autowired
    private IStudentService studentService;

    private String datelist;
    private String stulist;
    private Map<String, Object> actionRequest;
    private Sign sign;
    private SignInstanceTemplate template;
    private int templateid;


    public Sign getSign() {
        return sign;
    }

    public String getDatelist() {
        return datelist;
    }

    public void setDatelist(String datelist) {
        this.datelist = datelist;
    }

    public String getStulist() {
        return stulist;
    }

    public void setStulist(String stulist) {
        this.stulist = stulist;
    }


    public Map<String, Object> getActionRequest() {
        return actionRequest;
    }

    public void setActionRequest(Map<String, Object> actionRequest) {
        this.actionRequest = actionRequest;
    }


    public void setSign(Sign sign) {
        this.sign = sign;
    }


    public SignInstanceTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SignInstanceTemplate template) {
        this.template = template;
    }


    public int getTemplateid() {
        return templateid;
    }

    public void setTemplateid(int templateid) {
        this.templateid = templateid;
    }


    public String buildTask() {
        try {
            if (sign != null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                sign.setCreateTime((new Date()));
                taskService.insertSign(sign);
            }
            return "success";

        } catch (Exception e) {
            return "fail";
        }
    }

    public String buildTemplate()
    {

        Date date = null;
        DateFormat format = new SimpleDateFormat("HH:mm");
        HttpServletRequest request = ServletActionContext.getRequest();
        String beginTime = request.getParameter("template.startTime");//字符串
        beginTime = beginTime + ":00";
        System.out.println(beginTime);
        String endTime = request.getParameter("template.endTime");//字符串
        endTime = endTime + ":00";

        try {
            date = format.parse(beginTime);

            template.setStartTime(new Time(date.getTime()));
            date = format.parse(endTime);
            template.setEndTime(new Time(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            return "fail";
        }
        taskService.insertTemplate(template);


        return "success";
    }

    public String inToPlatform() {
        try {
            Map session = ActionContext.getContext().getSession();
            //session.get(teacher);

            Teacher teacher = (Teacher) session.get("teacher");
            TaskList taskList = taskService.getTaskList(teacher.getTeaID());


            session.put("taskList", taskList);

            session.put("teaID", teacher.getTeaID());


            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    public String gotoinstance() {
        try {
            actionRequest = (Map) ActionContext.getContext().get("request");
            List<Student> students = signInstanceService.listAllStudents();
            System.out.println(students.get(0).getName());
            HttpServletRequest request = ServletActionContext.getRequest();
            String templateid = request.getParameter("templateid");
            String chooseid = request.getParameter("chooseid");
            String choosename = request.getParameter("choosename");
            System.out.println(templateid);
            request.setAttribute("templateid", templateid);
            request.setAttribute("chooseid", chooseid);
            request.setAttribute("choosename", choosename);
            System.out.println(chooseid);
            System.out.println(choosename);
            System.out.println(templateid);

            actionRequest.put("students", students);

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
    public String newIns() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            System.out.println("学号是" + stulist);

            int chooseid = Integer.parseInt(request.getParameter("chooseid"));
            String[] date_list = datelist.split(",");
            String[] stu_list = stulist.split(",");
  /*      System.out.println("模板是" + templateid);
        System.out.println(date_list[0]);
        System.out.println(date_list[1]);
        System.out.println("学号是" + stu_list[0]);
        System.out.println("chooseid:" + chooseid);*/
            signInstanceService.insertSignInstance(stu_list, date_list, templateid, chooseid);
            return "success";

        } catch (Exception e) {
            return "fail";
        }
    }

    public String deleteInstance() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String templateid = request.getParameter("templateid");
            int templateId = Integer.parseInt(templateid);
            taskService.deleteTemplate(templateId);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

}
