package com.dapeng.ces.mapper;

import java.util.List;

import com.dapeng.ces.model.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
    int delete();
    
    Score selectByScoreId(String scoreId);
    
    List<Score> selectAllScore();
}