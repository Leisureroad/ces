package com.dapeng.ces.mapper;

import com.dapeng.ces.model.NationalRanking;

public interface NationalRankingMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(NationalRanking record);

    int insertSelective(NationalRanking record);

    NationalRanking selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(NationalRanking record);

    int updateByPrimaryKey(NationalRanking record);
    
    int delete();
}