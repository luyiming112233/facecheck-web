package cn.edu.zjut.service;



import cn.edu.zjut.dao.ResultMapper;
import cn.edu.zjut.po.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultService implements SignService{
	private ResultMapper resultmapper=null;
	public ResultService()
	{
		System.out.println("create ResultService");
	}
	public void setResultmapper(ResultMapper resultmapper)
	{
		System.out.println("now the resultservice setMapper");
		this.resultmapper=resultmapper;
	}
	public List getRByPId(int PId)
	{
		System.out.println("signservice-resultservice-ByPId");
		List<Result> list=new ArrayList();
		try{
			list=resultmapper.selectRByPId(PId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List getRById(int Id)
	{
		System.out.println("signservice-resultservice-ById");
		List<Result> list=new ArrayList();
		try{
			list=resultmapper.selectRById(Id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List getRByName(String name,int PId)
	{
		System.out.println("signservice-resultservice-ByName");
		List<Result> list=new ArrayList();
		try{
			System.out.println(name);
			list=resultmapper.selectRByName(name,PId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List getRByTime(Date time,int PId)
	{
		System.out.println("signservice-resultservice");
		List<Result> list=new ArrayList();
		try{
			list=resultmapper.selectRByTime(time,PId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List getResultDetails(int sign_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean changeResultDetails(int sign_id, boolean isSigned) {
		// TODO Auto-generated method stub
		return false;
	}
}
