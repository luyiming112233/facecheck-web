package cn.edu.zjut.service;

import cn.edu.zjut.dao.InstanceMapper;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.dao.StudentSignMapper;
import cn.edu.zjut.dao.TemplateMapper;
import cn.edu.zjut.po.SignInstance;
import cn.edu.zjut.po.SignInstanceTemplate;
import cn.edu.zjut.po.Student;
import cn.edu.zjut.po.StudentSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class SignInstanceService implements ISignInstanceService {
    @Autowired
    private TemplateMapper templateMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private InstanceMapper instanceMapper;
    @Autowired
    private StudentSignMapper studentSignMapper;

    private SignInstanceTemplate temp;

    private List<Student> studentlist=new ArrayList<Student>();

    private List<SignInstance> signInstances=new ArrayList<SignInstance>();

    public  int  insertSignInstance(String[] stu,String[] dates,int templateid,int chooseid)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        for(int i=0;i<stu.length;i++)
            System.out.println(stu[i]);

        for(int i=0;i<dates.length;i++)
            System.out.println(dates[i]);

        try {
            System.out.println(templateMapper);
             temp=templateMapper.getTemplateByid(templateid);
             System.out.println(temp.getStartTime());
             System.out.println("diming"+temp.getPlaceName());
             System.out.println("jingdu"+temp.getLatitude());
             System.out.println("tid"+temp.getTeaID());
             System.out.println("id"+temp.getTempID());
             for(int i=0;i<stu.length;i++) {
                 studentlist.add(studentMapper.getStudentById(Integer.parseInt(stu[i])));
             }

                 for(int j=0;j<dates.length;j++)
                 {
                     signInstances.add(new SignInstance(chooseid,temp.getStartTime(),temp.getEndTime(),temp.getLongitude(),temp.getLatitude(),temp.getRadius(),temp.getPlaceName(),sdf.parse(dates[j])));
                 }

             instanceMapper.insertSignInstance(signInstances);
/*System.out.println(signInstances.get(0).getSignInstID());
            System.out.println(signInstances.get(1).getSignInstID());*/
            StudentSign studentSig=new StudentSign();
                 for(int i=0;i<dates.length;i++)
                     for(int j=0;j<stu.length;j++)
                     {studentSig.setStuID(studentlist.get(j).getStuID());
                      studentSig.setSignInstID(signInstances.get(i).getSignInstID());
                         studentSignMapper.insertRecord(studentSig);

                     }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return 1;
    }


}
