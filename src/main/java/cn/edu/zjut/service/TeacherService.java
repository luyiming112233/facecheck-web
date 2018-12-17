package cn.edu.zjut.service;


import cn.edu.zjut.dao.TeacherMapper;
import cn.edu.zjut.po.Teacher;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService implements ITeacherService {
    private Map<String, Object> request, session;
    @Autowired
    private TeacherMapper teacherMapper = null;

    @Override
    public boolean login(Teacher teacher) {
        System.out.println(teacher.getTeaID());
        Teacher instance = new Teacher();
        try {
            instance = teacherMapper.findById(teacher.getTeaID());
            if (instance == null) {
                return false;
            } else {
                teacher = instance;
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean insertTeacher(Teacher teacher){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try{
            if(teacher!=null)
                teacher.setPassword("123456");//插入默认密码
                if(teacherMapper.insertTeacher(teacher)!=0) {
                    request.put("tip",teacher.getName()+"教师信息插入成功！");
                    return true;
                }
        }catch (Exception e){
            request.put("tip","教师信息插入失败！");
            return false;
        }
        request.put("tip","教师信息插入失败！");
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try{
            if(teacher!=null&&teacherMapper.updateTeacher(teacher)!=0) {
                request.put("tip","教师信息更新成功！");
                return true;
            }
        }catch (Exception e){
            request.put("tip","教师信息更新失败！");
            return false;
        }
        request.put("tip","教师信息更新失败！");
        return false;
    }

    @Override
    public boolean deleteTeacher(int teaID){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try {
            if(teacherMapper.deleteTeacher(teaID)!=0) {
                request.put("tip","教师信息删除成功！");
                return true;
            }

        }catch (Exception e){
            request.put("tip","教师信息删除失败！");
            return false;
        }
        request.put("tip","教师信息删除失败！");
        return false;
    }

    @Override
    public boolean listAllTeacher(){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        List<Teacher> teacherList = null;
        try{
            teacherList = teacherMapper.listAllTeacher();
            request.put("teacherList",teacherList);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Teacher getTeacherByID(int teaID){
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        try {
            Teacher teacher = teacherMapper.getTeacherById(teaID);
            return teacher;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean searchTeacherByTeacher(Teacher teacher){
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        request.remove("teacher");
        List<Teacher> teacherList = null;
        try{
            if(teacher.getTeaID()!=null){
                System.out.println("teaID:" + teacher.getTeaID());
                Teacher newTeacher = teacherMapper.getTeacherById(teacher.getTeaID());
                if(newTeacher !=null){
                    teacherList = new ArrayList<Teacher>();
                    teacherList.add(newTeacher);
                }
            }else if(teacher.getName()!=null){
                teacherList = teacherMapper.listTeacherByName(teacher.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(teacherList!=null){
            request.put("teacherList",teacherList);
            for(Teacher teacher1:teacherList){
                System.out.println(teacher1.getTeaID()+","+teacher1.getName());
            }
            return true;
        }else {
            request.put("tip", "查找失败！");
            System.out.println("fail");
            return false;
        }
    }
}
