package cn.edu.zjut.po;

import java.util.List;

public class Publisher {
    int id;//�����߱��
    String name;//����������
    private List<Result> results;//ǩ�����

    public void set(int id, String name, List<Result> results) {
        this.id = id;
        this.name = name;
        this.results = results;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


}
