package com.dapeng.ces.mapper;

import java.util.List;

import com.dapeng.ces.model.ScoreGroup;

public interface ScoreGroupMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ScoreGroup record);

    int insertSelective(ScoreGroup record);

    ScoreGroup selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ScoreGroup record);

    int updateByPrimaryKey(ScoreGroup record);
    
    int delete();
    
    List<ScoreGroup> selectAllScoreGroup();
}