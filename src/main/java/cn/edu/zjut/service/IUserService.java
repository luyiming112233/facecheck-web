package cn.edu.zjut.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public interface IUserService {
   public ByteArrayOutputStream exportExcel(ArrayList fieldName, ArrayList fieldData);
   public boolean inputExcel(File file);

}
