package cn.edu.zjut.dao;

import cn.edu.zjut.po.Result;

import java.util.Date;
import java.util.List;

public interface ResultMapper {
	public List<Result> selectRByPId(int PId) throws Exception;
	public List<Result> selectRById(int Id) throws Exception;
	public List<Result> selectRByName(String name, int PId) throws Exception;
	public List<Result> selectRByTime(Date time, int PId) throws Exception;
	

}
