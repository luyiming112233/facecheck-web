package cn.edu.zjut.po;

public class SingleDaily {
    private String dailyID;
    private String times;//打卡时段
    private String place;//打卡位置
    private int totalP;//总的要求打卡人数
    private int sucP;//成功打卡人数

    public SingleDaily() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SingleDaily(String dailyID, String times, String place, int totalP, int sucP) {
        super();
        this.dailyID = dailyID;
        this.times = times;
        this.place = place;
        this.totalP = totalP;
        this.sucP = sucP;
    }

    public String getDailyID() {
        return dailyID;
    }

    public void setDailyID(String dailyID) {
        this.dailyID = dailyID;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTotalP() {
        return totalP;
    }

    public void setTotalP(int totalP) {
        this.totalP = totalP;
    }

    public int getSucP() {
        return sucP;
    }

    public void setSucP(int sucP) {
        this.sucP = sucP;
    }

}
