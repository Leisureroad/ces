package com.dapeng.ces.mapper;

import com.dapeng.ces.model.UserScoreFemale;

public interface UserScoreFemaleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserScoreFemale record);

    int insertSelective(UserScoreFemale record);

    UserScoreFemale selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserScoreFemale record);

    int updateByPrimaryKey(UserScoreFemale record);
    
    int delete();
}