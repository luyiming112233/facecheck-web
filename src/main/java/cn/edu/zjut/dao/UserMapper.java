package cn.edu.zjut.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface UserMapper {
     public void insertStudent(ArrayList fieldData);
}
