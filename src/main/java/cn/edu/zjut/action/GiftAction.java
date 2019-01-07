package cn.edu.zjut.action;

import cn.edu.zjut.po.Gift;
import cn.edu.zjut.service.IGiftService;
import cn.edu.zjut.service.IStuGiftService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class GiftAction extends ActionSupport {
    private Map<String, Object> request, session;
    private File giftFile;
    private String giftFileContentType;    //得到上传文件的类型
    private String giftFileFileName;
    private List<Gift> gifts;
    @Autowired
    private Gift gift;
    @Autowired
    private IGiftService giftService;
    @Autowired
    private IStuGiftService stuGiftService;

    public void setStuGiftService(IStuGiftService stuGiftService) {
        this.stuGiftService = stuGiftService;
    }

    public IStuGiftService getStuGiftService() {
        return stuGiftService;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public File getGiftFile() {
        return giftFile;
    }

    public Gift getGift() {
        return gift;
    }

    public IGiftService getGiftService() {
        return giftService;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public void setGiftFile(File giftFile) {
        this.giftFile = giftFile;
    }

    public void setGiftService(IGiftService giftService) {
        this.giftService = giftService;
    }

    public String getGiftFileContentType() {
        return giftFileContentType;
    }


    public void setGiftFileContentType(String giftFileContentType) {
        this.giftFileContentType = giftFileContentType;
    }

    public String getGiftFileFileName() {
        return giftFileFileName;
    }

    public void setGiftFileFileName(String giftFileFileName) {
        this.giftFileFileName = giftFileFileName;
    }

    /**
     * 上传用于兑换的礼品信息
     *@Author 李璐瑶
     * @return
     */

    /**
     * 点击修改后获取该礼品信息
     *
     * @return
     * @Author 李璐瑶
     */
    public String changeGift() {
        // giftService.updateGift(gift,giftFile);
        System.out.println(gift.getGift_id());
        gift = giftService.getGiftById(gift.getGift_id());
        System.out.println(gift.getGift_img() + "-" + gift.getGift_descript() + "-" + gift.getGift_name());
        return "success-changeGift";
    }


    /**
     * 根据id删除礼品,若该礼品存在未兑换的请求，则删除失败
     *
     * @return
     * @Author 李璐瑶
     */
    public String deleteGift() {
        System.out.println("now the deleteAction");
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        if (stuGiftService.getListSize(gift.getGift_id()) > 0) {
            String tip = "该礼品存在未兑换请求，删除失败";
            request.put("tip", tip);
            return "fail";
        } else {
            giftService.deleteGift(gift.getGift_id());
            gifts = giftService.getAllGift();
            return "success-deleteGift";

        }
    }

    /**
     * 查看所有礼品信息
     *
     * @return
     * @Author 李璐瑶
     */
    public String lookAllGift() {
        gifts = giftService.getAllGift();
        return "success-lookAllGift";
    }
}
