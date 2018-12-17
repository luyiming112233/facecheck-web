package cn.edu.zjut.action;

import cn.edu.zjut.po.AllDaily;
import cn.edu.zjut.po.SingleDaily;
import cn.edu.zjut.service.DailyService;
import cn.edu.zjut.service.IDailyService;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class Dailyaction {
    IDailyService dailyService;
    List<AllDaily> allDailies;
    SingleDaily singleDaily;
    AllDaily allDaily;
    String cal;//模糊查询日期，得到页面上输入的日期片段

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getCal() {
        return cal;
    }

    public List<AllDaily> getAllDailies() {
        return allDailies;
    }

    public void setAllDailies(List<AllDaily> allDailies) {
        this.allDailies = allDailies;
    }

    public SingleDaily getSingleDaily() {
        return singleDaily;
    }

    public void setSingleDaily(SingleDaily singleDaily) {
        this.singleDaily = singleDaily;
    }

    public AllDaily getAllDaily() {
        return allDaily;
    }

    public void setAllDaily(AllDaily allDaily) {
        this.allDaily = allDaily;
    }

    //得到所有的打卡信息
    public String GetallDaily() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            allDailies = dailyService.getAllDaily();

            return "getallDailysuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyfail";
        }
    }

    //得到某个打卡详情
    public String GetsingleDaily() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            String dailyID = singleDaily.getDailyID();
            System.out.println(dailyID);
            singleDaily = dailyService.getsinDailyByDID(dailyID.trim());
            System.out.println(singleDaily.getSucP());
            return "getsingleDailysuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getsingleDailyfail";
        }
    }

    //根据发布人来查询打卡
    public String GetAllDailyByArrp() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            String arrPerson = allDaily.getArrPerson();
            allDailies = dailyService.getAllDailyByArrp(arrPerson);
            return "getAllDailyByArrpsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getAllDailyByArrpfail";
        }
    }

    //根据日期查询打卡
    public String GetAllDailyByCal() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            Date cal = allDaily.getCal();
            allDailies = dailyService.getAllDailyByCal(cal);
            return "getAllDailyByCalsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "GetAllDailyByCalfail";
        }
    }

    //根据打卡名来查询打卡
    public String GetallDailyByDName() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            String dailyName = allDaily.getDailyName();
            allDailies = dailyService.getallDailyByDName(dailyName);
            return "getallDailyByDNamesuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyByDNamefail";
        }
    }

    //根据打卡id查询具体的打卡
    public String GetallDailyByDID() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            String dailyID = allDaily.getDailyID();
            allDaily = dailyService.getallDailyByDID(dailyID);
            return "getallDailyByDIDsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyByDIDfail";
        }
    }

    //根据该打卡是否还有效来查询
    public String GetallDailyByVal() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            boolean isValidate = allDaily.getIsValidate();
            allDailies = dailyService.getallDailyByVal(isValidate);
            return "getallDailyByValsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyByValfail";
        }
    }

    //模糊查询某个打卡人发布的打卡
    public String GetallDailyByfuzzyArrp() {
        try {

            dailyService = CtxUtil.getBean(DailyService.class);
            String arrPerson = allDaily.getArrPerson();
            allDailies = dailyService.getallDailyByfuzzyArrp(arrPerson);
            return "getallDailyByfuzzyArrpsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyByfuzzyArrpfail";
        }
    }

    //模糊查询某一个日期下的打卡
    public String GetallDailyByfuzzyCal() {
        try {
            dailyService = CtxUtil.getBean(DailyService.class);
            allDailies = dailyService.getallDailyByfuzzyCal(cal);

            return "getallDailyByfuzzyCalsuccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "getallDailyByfuzzyCalfail";
        }
    }
}
