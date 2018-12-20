package cn.edu.zjut.service;

import cn.edu.zjut.po.Sign;


import java.util.List;

public interface IQuerySignService {
    List<Sign> getAllSign() throws Exception;//查询所有打卡记录
    List<Sign>getAllSignByName(String name)throws Exception;//根据打卡名查询打卡
    List<Sign>getAllSignByCreatetime(String createtime)throws Exception;//根据打卡创建时间查询打卡
    List<Sign>getAllSignByTeaid(int teaID)throws Exception;//根据教师id查询打卡
    List<Sign>getAllSignByID(int signID)throws Exception;//根据打卡id查询打卡

}
