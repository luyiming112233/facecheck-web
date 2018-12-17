package cn.edu.zjut.po;

import java.util.Date;

/**
 * 签到实例模板
 */
public class SignInstanceTemplate {
    private Integer tempID;//签到实例模板ID
    private Integer teaID;//教师ID（模板的拥有者）
    private Date startTime;//签到开始时间
    private Date endTime;//签到截止时间
    private String longitude;//签到地点经度
    private String latitude;//签到地点纬度
    private String placeName;//签到地点名称

    public SignInstanceTemplate(){ }

    public SignInstanceTemplate(Integer tempID, Integer teaID, Date startTime, Date endTime, String longitude, String latitude, String placeName) {
        this.tempID = tempID;
        this.teaID = teaID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeName = placeName;
    }

    public Integer getTempID() {
        return tempID;
    }

    public void setTempID(Integer tempID) {
        this.tempID = tempID;
    }

    public Integer getTeaID() {
        return teaID;
    }

    public void setTeaID(Integer teaID) {
        this.teaID = teaID;
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
}
