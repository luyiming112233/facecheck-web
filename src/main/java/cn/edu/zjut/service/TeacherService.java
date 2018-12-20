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

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public boolean login(Teacher teacher) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map)ctx.get("request");
        session = (Map) ctx.getSession();
        System.out.println(teacher.getTeaID());
        Teacher instance = new Teacher();
        try {
            instance = teacherMapper.findById(teacher.getTeaID());
            if (instance == null) {
                System.out.println(11111);
                return false;
            }
            if (instance.getPassword().equals(teacher.getPassword())) {
                teacher = instance;
                session.put("teacher",teacher);
                return true;
            }
        } catch (Exception e) {
            System.out.println(2222);
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
        session =ctx.getSession();
        try {
            teacherMapper.deleteTeacher(teaID);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        List<Teacher> teacherList = (List<Teacher>)session.get("teacherList");
        for(Teacher teacher:teacherList){
            if(teacher.getTeaID()==teaID){
                teacherList.remove(teacher);
                break;
            }
        }
        session.put("teacherList",teacherList);
        return true;
    }

    @Override
    public boolean listAllTeacher(){
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Teacher> teacherList = null;
        try{
            teacherList = teacherMapper.listAllTeacher();
            session.put("teacherList",teacherList);
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
    public boolean searchTeacher(String teaMess, int type){
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        List<Teacher> teacherList = null;
        // 0:按学号查询；1：按姓名查询；
        try {
            switch (type) {
                case 0:
                    Teacher teacher = teacherMapper.getTeacherById(Integer.parseInt(teaMess));
                    teacherList = new ArrayList<Teacher>();
                    teacherList.add(teacher);
                    break;
                case 1:
                    teacherList = teacherMapper.listTeacherByName(teaMess);
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        if (teacherList != null) {
            session.put("teacherList", teacherList);
            return true;
        }
        return false;
    }
}
