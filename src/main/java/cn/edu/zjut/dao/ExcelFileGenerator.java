package cn.edu.zjut.dao;
/**
 * ϵͳ���ݵ���Excel ������
 * @version 1.0
 */


import cn.edu.zjut.po.Student;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class ExcelFileGenerator {
 
	private final int SPLIT_COUNT = 1500; //Excelÿ��������������
 
	
 
	private HSSFWorkbook workBook = null;
 
	/**
	 * ������
	 * @param fieldName ��������ֶ���
	 * @param data
	 */
	/**
	 * ����HSSFWorkbook����
	 * @return HSSFWorkbook
	 */
	public HSSFWorkbook createWorkbook(ArrayList fieldName,ArrayList<Student>fieldData) {
 
		workBook = new HSSFWorkbook();
		int rows = fieldData.size();
		int sheetNum = 0;
 
		if (rows % SPLIT_COUNT == 0) {
			sheetNum = rows / SPLIT_COUNT;
		} else {
			sheetNum = rows / SPLIT_COUNT + 1;
		}
 
		for (int i = 1; i <= sheetNum; i++) {
			HSSFSheet sheet = workBook.createSheet("Page " + i);
			HSSFRow headRow = sheet.createRow((short) 0); 
			for (int j = 0; j < fieldName.size(); j++) {
				HSSFCell cell = headRow.createCell((short) j);
				//�����ʽ
				//cell.setCellType(HSSFCell.);
				//((Object) cell).setEncoding(HSSFCell.ENCODING_UTF_16);
				//�����ʽ
				//�������е�Ԫ��Ŀ��
				sheet.setColumnWidth((short)j, (short)6000);
				//������ʽ(ʹ�ù������Ķ��󴴽�)
				HSSFCellStyle cellStyle = workBook.createCellStyle();
				//��������Ķ���
				HSSFFont font = workBook.createFont();
				//������Ӵ�
				//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				//�����������ɫ
				//short color = HSSFColor.RED.index;
				//font.setColor(color);
				//�������õ��������Է��õ���ʽ��
				cellStyle.setFont(font);
				if(fieldName.get(j) != null){
					cell.setCellStyle(cellStyle);
					cell.setCellValue((String) fieldName.get(j));
				}else{
					cell.setCellStyle(cellStyle);
					cell.setCellValue("-");
				}
			}
			Iterator itf=fieldData.iterator();
			for(int tem=0;tem<(i-1)*SPLIT_COUNT;tem++){
				itf.next();
			}
			Iterator it=itf;
				for(int k=0;k <(rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++){
					HSSFRow row = sheet.createRow((short) (k + 1));
					Student student=(Student) it.next();
					HSSFCell cell0=row.createCell(0);
					cell0.setCellValue(student.getStuID());
					HSSFCell cell1=row.createCell(1);
					cell1.setCellValue(student.getName());
					HSSFCell cell2=row.createCell(2);
					cell2.setCellValue(student.getPassword());
					HSSFCell cell3=row.createCell(3);
					cell3.setCellValue(student.getClazz());
					HSSFCell cell4=row.createCell(4);
					cell4.setCellValue(student.getDepart());
					HSSFCell cell5=row.createCell(5);
					cell5.setCellValue(student.getEmail());



			}
		}
		return workBook;
	}
 
	public void exportExcel(OutputStream os,ArrayList fieldName,ArrayList fieldData) throws Exception {
		workBook = createWorkbook(fieldName,fieldData);
		workBook.write(os);
		os.close();
	}

    public ArrayList<Student>inputExcel(File file) throws IOException{
    	ArrayList<Student> stuField=new ArrayList();
    	 String tempDir = "D:\\a";
         File target = new File("D:\\a","excel.xls");
         if(target.exists())
        	 target.delete();
         target.createNewFile();
         //ɾ��֮ǰ�ϴ��ľ��ļ�
         System.out.println("copy");
         FileUtils.copyFile((File) file,target);
 
    		System.out.println("inputStream Start");
        FileInputStream is=new FileInputStream("D:\\a\\excel.xls");
        System.out.println("      1");
		workBook = new HSSFWorkbook(is);
		try{
		for(int i=0;i<workBook.getNumberOfSheets();i++){
			HSSFSheet sh = workBook.getSheetAt(i);
			for(int j=1;sh.getRow(j)!=null;j++){
				HSSFRow row =sh.getRow(j);
				Student student=new Student();

               student.setStuID((int)Double.parseDouble(row.getCell(0).toString().trim()));
				student.setName(row.getCell(1).toString());
				student.setPassword(row.getCell(2).toString());
				student.setClazz(row.getCell(3).toString());
				student.setDepart(row.getCell(4).toString());
				student.setEmail(row.getCell(5).toString());
				System.out.println(student.getStuID());
				stuField.add(student);
				}
			}
    }
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	return stuField;
    }
	public ArrayList getFieldName(InputStream is,File target,ArrayList fieldName) throws IOException{
		
		HSSFSheet sh = workBook.getSheetAt(0);
	    HSSFRow row =sh.getRow(0);
       for(int i=0;row.getCell(i)!=null;i++){
    	   HSSFCell cell=row.getCell(i);
    	   fieldName.add(row.getCell(i).toString());
       }
    	   return fieldName;
       }
	

	}

	  
	
	

