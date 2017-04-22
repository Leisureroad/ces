package com.dapeng.ces.mapper;

import java.util.List;

import com.dapeng.ces.model.ScoreFemale;

public interface ScoreFemaleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ScoreFemale record);

    int insertSelective(ScoreFemale record);

    ScoreFemale selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ScoreFemale record);

    int updateByPrimaryKey(ScoreFemale record);
    
    int delete();
    
    List<ScoreFemale> selectAllScoreFemale();
}