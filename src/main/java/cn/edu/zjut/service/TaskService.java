package cn.edu.zjut.service;

import cn.edu.zjut.dao.TaskMapper;
import cn.edu.zjut.dao.TemplateMapper;
import cn.edu.zjut.po.Sign;
import cn.edu.zjut.po.SignInstanceTemplate;
import cn.edu.zjut.po.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {
@Autowired
TaskMapper taskMapper = null;
    @Autowired
    TemplateMapper templateMapper=null;


    public boolean insertSign(Sign sign)  {

        try {
            taskMapper.insertSignProject(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    public boolean insertTemplate(SignInstanceTemplate template)  {

        try {
            templateMapper.insertTemplate(template);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteTemplate(int templateId)  {

        try {
            templateMapper.DeleteTemplate(templateId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    public TaskList getTaskList(int teaID)  {

        TaskList taskList=new TaskList();

        try {

            taskList.setTeaID(   new Integer(teaID));

            taskList.setSigns(taskMapper.getSignProjectById(new Integer(teaID)));
            System.out.println(taskMapper.getSignProjectById(new Integer(teaID)));

            taskList.setTemplates(templateMapper.getTemplateByTid(new Integer(teaID)));


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

      return taskList;
    }


}
