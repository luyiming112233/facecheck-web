package cn.edu.zjut.action;

import cn.edu.zjut.po.Notice;
import cn.edu.zjut.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NoticeAction {
    private Notice notice;
    @Autowired
    private INoticeService noticeService;
public  void setNotice(Notice notice){
    this.notice=notice;
}
public Notice getNotice(){
    return notice;
    }
    public void setNoticeService(INoticeService noticeService){
    this.noticeService=noticeService;
    }
    public INoticeService noticeService(){
    return  noticeService;
    }

    public String notice() {
        try {
            System.out.println(notice.getContent()+notice.getTitle());
            if (noticeService.makeNotice(notice))
                return "success";
            return "fails";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
