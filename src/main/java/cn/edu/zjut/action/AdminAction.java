package cn.edu.zjut.action;


import cn.edu.zjut.po.Admin;
import cn.edu.zjut.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminAction {
    private Admin admin;

    @Autowired
    private IAdminService adminService = null;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String login() {
        System.out.println(admin.getAdminID());
        if (adminService.login(admin)) {
            return "success";
        } else
            return "fail";
    }

    public String register() {
        if (adminService.register(admin)) {
            return "success";
        }
        return "fail";
    }
}
