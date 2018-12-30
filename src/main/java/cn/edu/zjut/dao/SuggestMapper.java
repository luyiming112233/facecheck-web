package cn.edu.zjut.dao;

import cn.edu.zjut.po.Suggest;
import org.springframework.stereotype.Repository;
@Repository
public interface SuggestMapper {
    public void insertSuggest(Suggest suggest);

}
