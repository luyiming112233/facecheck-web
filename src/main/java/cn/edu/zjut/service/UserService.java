package cn.edu.zjut.service;


import cn.edu.zjut.dao.ExcelFileGenerator;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Student;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class UserService implements IUserService {
	@Autowired
	private ExcelFileGenerator excelFileGenerator;
	@Autowired
	private StudentMapper studentMapper;
	public ByteArrayOutputStream exportExcel(ArrayList fieldName,ArrayList fieldData) {
		System.out.println("Service Start");
		ActionContext ctx = ActionContext.getContext();
		try {
			// 初始化fieldName，fieldDate
			fieldName = getFieldName(); // excel标题数据集
			fieldData = getFieldData(); // excel数据内容
			String myexcel = "myexcel";
			// 回去输出流
			System.out.println(11111);
			ByteArrayOutputStream out = new ByteArrayOutputStream(); 
			// 重置输出流
			// 设置导出Excel报表的导出形式
			//response.setContentType("application/vnd.ms-excel");
			//response.setHeader("Content-Disposition", "attachment;filename=" + myexcel + ".xls");


			excelFileGenerator.exportExcel(out,fieldName,fieldData);
			
			System.out.println(11111);
			// 设置输出形式
			//System.setOut(new PrintStream(out));
			// 刷新输出流
			out.flush();
			// 关闭输出流
			System.out.println(11111);
			if (out != null) {
				out.close();
			}
			return out;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
	}

	public ArrayList getFieldName() {
		String str[] = { "学生学号","姓名","密码","班级名称","系名","email地址"};
		ArrayList list = new ArrayList();
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}
		return list;
	}

	// 模拟提供excel中的标题数据内容
	public ArrayList<Student> getFieldData() {
		ArrayList list1 = new ArrayList();
		Student student=new Student();
		student.setStuID(1111);
		student.setName("111");
		student.setClazz("1111");
		student.setPassword("1111");
		student.setDepart("1111");
		student.setEmail("11111");
		list1.add(student);
		Student student1=new Student();

		student1.setStuID(2222);
		student1.setName("2222");
		student1.setClazz("2222");
		student1.setPassword("2222");
		student1.setDepart("2222");
		student1.setEmail("2222");
		list1.add(student1);
		Iterator i=list1.iterator();
		while(i.hasNext()){
			System.out.println(i.next().getClass());


		}
		return list1;
	}
	
	public void setExcelFileGenerator(ExcelFileGenerator excelFileGenerator){
	this.excelFileGenerator=excelFileGenerator;	
	}
	public ExcelFileGenerator getExcelFileGenerator(){
		return excelFileGenerator;
	}
	
	public void setStudentMapper(StudentMapper studentMapper){
		this.studentMapper =studentMapper;
	}
	public StudentMapper getStudentMapper(){
		return studentMapper;
	}

	public boolean inputExcel(File file){
		ActionContext ctx = ActionContext.getContext();
		ArrayList<Student> stuField=null;
	try{
		System.out.println("UserService Start");
		stuField=excelFileGenerator.inputExcel(file);
		for(Iterator i=stuField.iterator();i.hasNext();)
			System.out.println(((Student) i.next()).getStuID());
		studentMapper.insertStudentExcel(stuField);
		studentMapper.insertStudentFace(stuField);
		return true;
	}
	catch(Exception e){
		System.out.println(e);
	}
	System.out.println("youwenti");
	return false;
	}


}
