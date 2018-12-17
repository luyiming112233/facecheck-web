package cn.edu.zjut.dao;

import cn.edu.zjut.po.ResultD;

import java.util.List;

public interface ResultDMapper {
	public List<ResultD> selectDetailsBySign_id(int sign_id) throws Exception;

	public boolean updateResultDetail(int sign_id, boolean isSigned);
	

}
