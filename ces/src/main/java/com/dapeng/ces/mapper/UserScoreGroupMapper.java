package com.dapeng.ces.mapper;

import java.util.List;

import com.dapeng.ces.model.UserScoreGroup;

public interface UserScoreGroupMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserScoreGroup record);

    int insertSelective(UserScoreGroup record);

    UserScoreGroup selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserScoreGroup record);

    int delete();
    
    int updateByPrimaryKey(UserScoreGroup record);
    
    List<UserScoreGroup> selectAllUserScoreGroup();
}