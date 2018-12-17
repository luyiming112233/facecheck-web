package cn.edu.zjut.service;



import cn.edu.zjut.dao.PublisherMapper;

import java.util.Date;
import java.util.List;

public class PublisherService implements SignService{

	private PublisherMapper publishermapper=null;
	public PublisherService()
	{
		System.out.println("create ResultService");
	}
	public void setPublishermapper(PublisherMapper publishermapper)
	{
		System.out.println("now the publisherservice setMapper");
		this.publishermapper=publishermapper;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List getRById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean changeResultDetails(int sign_id, boolean isSigned) {
		// TODO Auto-generated method stub
		return false;
	}

}
