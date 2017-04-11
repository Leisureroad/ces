package com.dapeng.ces.mapper;

import java.util.List;

import com.dapeng.ces.model.Gene;

public interface GeneMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Gene record);

    int insertSelective(Gene record);

    Gene selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Gene record);

    int updateByPrimaryKey(Gene record);
    
    int delete();
    
    List<Gene> selectByUserId(String userId);
    
}