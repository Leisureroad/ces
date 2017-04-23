package com.dapeng.ces.mapper;

import java.util.List;
import java.util.Map;

import com.dapeng.ces.dto.UserOriginalResult;
import com.dapeng.ces.dto.UserScoreDtoResult;
import com.dapeng.ces.dto.UserScoreFemaleResult;
import com.dapeng.ces.dto.UserScorePlayerResult;
import com.dapeng.ces.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int delete();
    
    List<User> selectAllUser();
    
    List<UserScoreDtoResult> selectUserScoreInfo(String name);
    
    List<UserOriginalResult> selectUserOriginal(String name);
    
    List<UserScorePlayerResult> selectUserPlayer(String star);
    
    List<UserScoreDtoResult> getUserOriginalType(Map<String, String> map);
    
    List<UserScoreDtoResult> getUserScoreType(Map<String, String> map);
    
    User selectByName(String name);
    //根据性别查询运动员信息
    List<User> selectUserBySex(Map<String, String> map);
    
    UserScoreFemaleResult selectUserScoreFemale(String name);
}