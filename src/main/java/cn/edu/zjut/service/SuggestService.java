package cn.edu.zjut.service;

import cn.edu.zjut.dao.SuggestMapper;
import cn.edu.zjut.po.Suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SuggestService implements ISuggestService{
    @Autowired
    SuggestMapper suggestMapper;
    public boolean suggestm(Suggest suggest) {
        try{

            System.out.println(suggest.getTeacher().getName());
            suggestMapper.insertSuggest(suggest);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
