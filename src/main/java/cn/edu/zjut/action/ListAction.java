package cn.edu.zjut.action;

import cn.edu.zjut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

@Controller
public class ListAction {

	private InputStream excelFile;
	@Autowired
	private IUserService userService;
	private ArrayList fieldName=null ; //excel标题数据集
	private ArrayList fieldData=null ; //excel数据内容
	private File file;
	
	public void setFile(File file){
		System.out.println("set myfile");
		if(file==null)
			System.out.println("文件是空的");
		this.file=file;
	}
	public File getFile(){
		return file;
	}

	public String exportExcel() {
		System.out.println(11111);
		try {

			System.out.println("4324324");
			byte[] ba = userService.exportExcel(fieldName, fieldData).toByteArray();
			excelFile = new ByteArrayInputStream(ba);
			return "success";
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("action de wenti");
		}
            return "fail";
	}
	
	public String inputExcel(){
		System.out.println("Starting inport");
       if(userService.inputExcel(file))	{
    	   return "success";
       }
       else
    	   return "fail";
	}
    public InputStream getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(InputStream excelFile) {
        this.excelFile = excelFile;
    }
    public void setFieldName(ArrayList fieldName){
    	this.fieldName=fieldName;
    }
    public ArrayList getFieldName(){
    	return fieldName;
    }
    public void setFieldData(ArrayList fieldData){
    	this.fieldData=fieldData;
    }
    public ArrayList getFieldData(){
    	return fieldData;
    }
    public void setUserService(IUserService userService){
    	this.userService=userService;
    }
    public IUserService getUserService(){
    	return userService;
    }
}
