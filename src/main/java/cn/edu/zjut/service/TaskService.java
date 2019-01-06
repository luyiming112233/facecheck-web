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
    TemplateMapper templateMapper = null;

    /**
     *
     * @param sign 选择插入的计划实例
     * @Describe  教师功能中打卡计划的插入
     * @return
     */
    public boolean insertSign(Sign sign) {

        try {
            taskMapper.insertSignProject(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     *
     * @param template 选择插入的模板信息的实例
     * @return 教师功能中模板信息的插入
     */
    public boolean insertTemplate(SignInstanceTemplate template) {

        try {
            templateMapper.insertTemplate(template);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     *
     * @param templateId 需要删除的模板id
     * @Describe 教师模板管理中的模板删除功能
     * @return
     */
    public boolean deleteTemplate(int templateId) {

        try {
            templateMapper.DeleteTemplate(templateId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     *
     * @param teaID 需要获取的所有计划对应的教师id
     * @Describe 查询相应教师存储的所有签到计划
     * @return
     */
    public TaskList getTaskList(int teaID) {

        TaskList taskList = new TaskList();

        try {

            taskList.setTeaID(new Integer(teaID));
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
