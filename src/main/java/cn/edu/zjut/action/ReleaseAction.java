package cn.edu.zjut.action;

import cn.edu.zjut.service.SendCodeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope("prototype")
public class ReleaseAction {

    @Autowired
    private SendCodeService sendcode;

    public void sendmsg() throws Exception {

        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String phone = request.getParameter("phone");
        System.out.println(phone);
        String msg = sendcode.sendmsg(phone);
        System.out.println(msg);

        ;
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msg);


    }


}
