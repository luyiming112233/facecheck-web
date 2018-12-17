package cn.edu.zjut.po;

public class ResultD {
    int Id;
    int sign_id;
    //String sign_name;
    String stu_id;
    String stu_name;
    String stu_class;
    boolean isSigned;

    public void set(int Id, int sign_id, String stu_id, String stu_name, String stu_class, boolean isSigned) {
        this.Id = Id;
        this.sign_id = sign_id;
        this.stu_id = stu_id;
        this.stu_class = stu_class;
        this.stu_name = stu_name;
        this.isSigned = isSigned;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setSign_id(int sign_id) {
        this.sign_id = sign_id;
    }

    public int getSign_id() {
        return sign_id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_class() {
        return stu_class;
    }

    public boolean getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(boolean isSigned) {
        this.isSigned = isSigned;
    }


}
