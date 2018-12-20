/**
 * JWW
 */


package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdminMapper;
import cn.edu.zjut.po.Admin;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminService implements IAdminService {
    private Map<String, Object> request, session;
    @Autowired
    private AdminMapper adminMapper = null;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public boolean login(Admin admin) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        session = (Map) ctx.getSession();
        Admin instance = new Admin();

        try {
            instance = adminMapper.findById(admin.getAdminID());

        if (instance == null) {
            System.out.println("null");
            return false;
        }
        if(admin.getPassword().equals(instance.getPassword())){
            admin=instance;
            session.put("admin",admin);
            return true;
        }
        else{
            System.out.println(instance.getPassword());
            System.out.println(instance.getAdminID());
            System.out.println("密码不对！");
            return false;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(Admin admin) {
        try {
            adminMapper.saveAdmin(admin);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

}
