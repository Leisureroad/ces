package com.dapeng.ces.mapper;

import com.dapeng.ces.model.UserScore;

public interface UserScoreMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    UserScore selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);
    
    int delete();
}