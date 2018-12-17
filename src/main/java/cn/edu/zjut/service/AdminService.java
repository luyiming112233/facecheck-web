/**
 * JWW
 */


package cn.edu.zjut.service;

import cn.edu.zjut.dao.AdminMapper;
import cn.edu.zjut.po.Admin;

import java.util.Map;


public class AdminService implements IAdminService {
    private Map<String, Object> request, session;
    private AdminMapper adminMapper = null;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public boolean login(Admin admin) {
        Admin instance = new Admin();

        try {
            instance = adminMapper.findById(admin.getAdminID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (instance == null) {
            System.out.println("null");
            return false;
        }
        else {
            return true;
        }
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
