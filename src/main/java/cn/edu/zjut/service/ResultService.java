package cn.edu.zjut.service;



import cn.edu.zjut.dao.ResultMapper;
import cn.edu.zjut.po.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class ResultService implements IResultService{
	@Autowired
	private ResultMapper resultmapper;
	public ResultService()
	{
		System.out.println("create ResultService");
	}
	@Resource
	public void setResultmapper(ResultMapper resultmapper)
	{
		this.resultmapper=resultmapper;
	}

	@Override

	public List<Sign> getByTeacher_id(int teacher_id) {//根据老师的id查找它的所有打卡任务
		System.out.println("resultservice-getByTeacher_id");
		List<Sign> list=new ArrayList();
		try{
			list=resultmapper.selectByTeacher_id(teacher_id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Sign> getBySign_name(String sign_name,int teacher_id) {//按名次查找
		System.out.println("resultservice-getBySign_name");
		List<Sign> list=new ArrayList();
		try{
			list=resultmapper.selectBySign_name(sign_name,teacher_id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Sign> getByCreatetime(java.util.Date createtime, int teacher_id) {//按创建时间查找
		System.out.println("resultservice-getByCreatetime");
		List<Sign> list=new ArrayList();
		try{
			list=resultmapper.selectByCreatetime(createtime,teacher_id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Sign getBySign_id(int sign_id) {//查找某个具体的大打卡
		System.out.println("resultservice-getBySign_id");
		Sign sign=null;
		try{
			sign=resultmapper.selectBySign_id(sign_id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sign;
		// TODO Auto-generated method stub
	}
}
