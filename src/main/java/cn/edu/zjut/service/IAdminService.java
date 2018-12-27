/**
 * JWW
 */
package cn.edu.zjut.service;


import cn.edu.zjut.po.Admin;

public interface IAdminService {
    /**
     * @Author Jinweiwei
     * @Describe 管理员登录
     * @param admin
     * @return
     */
    public boolean login(Admin admin);

    public boolean register(Admin admin);
}
