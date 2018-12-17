package cn.edu.zjut.dao;

import cn.edu.zjut.po.Admin;

public interface AdminMapper {
		public Admin findById(int id) throws Exception;

		public void saveAdmin(Admin admin) throws Exception;
}
