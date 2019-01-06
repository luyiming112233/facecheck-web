package cn.edu.zjut.action;

import cn.edu.zjut.po.GiftChange;
import cn.edu.zjut.service.IGiftService;
import cn.edu.zjut.service.IStuGiftService;
import cn.edu.zjut.service.StuGiftService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentGiftAction extends ActionSupport {
    @Autowired
    private IStuGiftService stuGiftService;
    @Autowired
    private IGiftService giftService;
    private GiftChange giftChange;

    public void setGiftService(IGiftService giftService) {
        this.giftService = giftService;
    }

    public IGiftService getGiftService() {
        return giftService;
    }

    public GiftChange getGiftChange() {
        return giftChange;
    }

    public void setGiftChange(GiftChange giftChange) {
        this.giftChange = giftChange;
    }

    List<GiftChange> giftChanges = new ArrayList<>();

    public List<GiftChange> getGiftChanges() {
        return giftChanges;
    }

    public void setGiftChanges(List<GiftChange> giftChanges) {
        this.giftChanges = giftChanges;
    }

    public IStuGiftService getStuGiftService() {
        return stuGiftService;
    }

    public void setStuGiftService(IStuGiftService stuGiftService) {
        this.stuGiftService = stuGiftService;
    }

    /**
     * 查看请求兑换的信息
     *
     * @return
     * @Author 李璐瑶
     */
    public String lookStudentGift() {
        System.out.println("now the lookStudentGift");
        giftChanges = stuGiftService.getStudentGift();
        System.out.println(giftChanges.size());
        System.out.println(giftChanges.get(0).getSg().getAutoid() + "-" + giftChanges.get(0).getSg().getResult() + "-" + giftChanges.get(0).getSg().getQuantity());
        return "success-lookStudentGift";
    }

    /**
     * 允许兑换后修改兑换结果
     *
     * @return
     * @Author 李璐瑶
     */

    public String applyChange() {
        System.out.println("now appplyChange" + giftChange.getSg().getAutoid() + giftChange.getSg().getQuantity());
        stuGiftService.updateStuGift(giftChange.getSg().getResult(), giftChange.getSg().getAutoid());
        giftChanges = stuGiftService.getStudentGift();
        return "success-applyChange";
    }

    /**
     * 拒绝兑换后还原礼品数目，删除该礼品请求信息
     *
     * @return
     * @Author 李璐瑶
     */
    public String refuseChange() {
        System.out.println("now refuseChange" + giftChange.getSg().getAutoid() + giftChange.getSg().getQuantity());
        if (!giftChange.getSg().getResult()) {
            System.out.println("------------------");
            giftService.changeQuantity(giftChange.getSg().getGift_id(), giftChange.getSg().getQuantity());
            stuGiftService.deleteStuGift(giftChange.getSg().getAutoid());
        }
        giftChanges = stuGiftService.getStudentGift();
        return "success-refuseChange";
    }

}
