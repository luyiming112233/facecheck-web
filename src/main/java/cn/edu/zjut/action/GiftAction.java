package cn.edu.zjut.action;

import cn.edu.zjut.po.Gift;
import cn.edu.zjut.service.IGiftService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class GiftAction extends ActionSupport {
    private File giftFile;
    private String giftFileContentType;    //得到上传文件的类型
    private String giftFileFileName;
    private List<Gift> gifts;
    @Autowired
    private Gift gift;
    @Autowired
    private IGiftService giftService;

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
     * @return
     */
    public String addGift() {
        System.out.println("now giftAction");
        System.out.println("now giftAction" + giftFile.getName() + "--" + giftFile.getAbsolutePath());
        System.out.println("filename   :" + this.getGiftFileFileName());
        System.out.println("uploadType    :" + this.getGiftFileContentType());
        System.out.println("file" + this.giftFile);
        giftService.insertGift(gift, giftFile);
        return "success-addGift";
    }

    /**
     * 点击修改后获取该礼品信息
     * @return
     */
    public String changeGift() {
        // giftService.updateGift(gift,giftFile);
        System.out.println(gift.getGift_id());
        gift = giftService.getGiftById(gift.getGift_id());
        System.out.println(gift.getGift_img() + "-" + gift.getGift_descript() + "-" + gift.getGift_name());
        return "success-changeGift";
    }

    /**
     * 修改礼品信息
     * @return
     */
    public String updateGift() {
        System.out.println("now action updateGift");

        giftService.updateGift(gift, giftFile);
        gifts = giftService.getAllGift();
        return "success-updateGift";
    }

    /**
     * 根据id删除礼品
     * @return
     */
    public String deleteGift() {
        System.out.println("now the deleteAction");
        giftService.deleteGift(gift.getGift_id());
        gifts = giftService.getAllGift();
        return "success-deleteGift";
    }

    /**
     * 查看所有礼品信息
     * @return
     */
    public String lookAllGift() {
        gifts = giftService.getAllGift();
        return "success-lookAllGift";
    }
}
