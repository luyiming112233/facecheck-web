package cn.edu.zjut.service;

import cn.edu.zjut.dao.NoticeMapper;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Notice;
import cn.edu.zjut.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
@Service
public class NoticeService implements  INoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    StudentMapper studentMapper;

    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public NoticeMapper noticeMapper() {
        return noticeMapper;
    }

    public boolean makeNotice(Notice notice) {
        try {
            System.out.println(notice.getTeaID());
            System.out.println(notice.getContent()+notice.getTitle());
            notice.setDate(new Date());
            notice.incre();
            noticeMapper.insertNotice(notice);
            int id=noticeMapper.selectMaxId();
            ArrayList<Student> stu = (ArrayList<Student>) studentMapper.listAllStudent();
            ArrayList<Notice> notices = new ArrayList<Notice>();
            for (Iterator it = stu.iterator(); it.hasNext(); ) {
                Notice notice1 = new Notice();
                notice1.setStuID(((Student) it.next()).getStuID());
                notice1.setDate(notice.getDate());
                notice1.setNoticeID(id);
                notices.add(notice1);

            }
            noticeMapper.insertStuNotice(notices);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
