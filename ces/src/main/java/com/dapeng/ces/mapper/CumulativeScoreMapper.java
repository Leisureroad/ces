package com.dapeng.ces.mapper;

import java.util.List;
import java.util.Map;

import com.dapeng.ces.model.CumulativeScore;

public interface CumulativeScoreMapper {
    int deleteByPrimaryKey(String userId);

    int insert(CumulativeScore record);

    int insertSelective(CumulativeScore record);

    CumulativeScore selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(CumulativeScore record);

    int updateByPrimaryKey(CumulativeScore record);
    
    int delete();
    
    CumulativeScore selectByUserName(String userName);
        
    List<CumulativeScore> selectUserScore_explosive(Map<String, String> map);
    
    List<CumulativeScore> selectUserScore_injury(Map<String, String> map);
    
    List<CumulativeScore> selectUserScore_injury_risk(Map<String, String> map);
    
    List<CumulativeScore> selectUserScore_obesity(Map<String, String> map);
}