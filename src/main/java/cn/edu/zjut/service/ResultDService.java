package cn.edu.zjut.service;



import cn.edu.zjut.dao.ResultDMapper;
import cn.edu.zjut.po.ResultD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultDService implements SignService {
	private ResultDMapper resultDmapper;
	public ResultDService()
	{
		System.out.println("create ResultDService");
	}
	public void setResultDmapper(ResultDMapper resultDmapper)
	{
		this.resultDmapper=resultDmapper;
	}
	public ResultDMapper getMapper()
	{
		return resultDmapper;
	}

	@Override
	public List getRByPId(int PId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getRByName(String name,int PId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getRByTime(Date time,int PId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getResultDetails(int sign_id) {
		System.out.println("now ResultDService-getDetails"+sign_id);
		List<ResultD> list=new ArrayList();
		/*ResultD r=new ResultD();
		ResultD r1=new ResultD();
		r.setStu_name("aaaaaa");
		r1.setStu_name("qqqqqqqqqqqqqq");
		list.add(r);
		list.add(r1);
		return list;*/
		try{
			list=resultDmapper.selectDetailsBySign_id(sign_id);
			System.out.println(list.get(0).getStu_name());
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List getRById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean changeResultDetails(int sign_id, boolean isSigned) {
		try{
			resultDmapper.updateResultDetail(sign_id,isSigned);
		}catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
		


}
