/**
 * JWW
 */
package cn.edu.zjut.service;


import cn.edu.zjut.po.Admin;

public interface IAdminService {
    public boolean login(Admin admin);

    public boolean register(Admin admin);
}
