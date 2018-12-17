package cn.edu.zjut.service;

import java.util.Date;
import java.util.List;

public interface SignService {
	public List getRByPId(int PId);
	public List getRById(int Id);
	public List getRByName(String name, int PId);
	public List getRByTime(Date time, int PId);
	public List getResultDetails(int sign_id);
	public boolean changeResultDetails(int sign_id, boolean isSigned);
	
}
