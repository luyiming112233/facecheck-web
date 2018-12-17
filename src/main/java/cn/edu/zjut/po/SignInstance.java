package cn.edu.zjut.po;

import java.util.Date;

/**
 * 签到实例
 */
public class SignInstance {
    private Integer signInstID;//签到实例id
    private String signID;//对应签到信息表id
    private Date startTime;//开始时间
    private Date endTime;//截止时间
    private String longitude;//签到地点经度
    private String latitude;//签到地点纬度
    private String placeName;//签到地点名称
    private Date date;//签到日期

    public SignInstance() { }

    public SignInstance(Integer signInstID, String signID, Date startTime, Date endTime, String longitude, String latitude, String placeName, Date date) {
        this.signInstID = signInstID;
        this.signID = signID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeName = placeName;
        this.date = date;
    }

    public Integer getSignInstID() {
        return signInstID;
    }

    public void setSignInstID(Integer signInstID) {
        this.signInstID = signInstID;
    }

    public String getSignID() {
        return signID;
    }

    public void setSignID(String signID) {
        this.signID = signID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
