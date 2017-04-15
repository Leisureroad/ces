package com.dapeng.ces.mapper;

import java.util.List;
import java.util.Map;

import com.dapeng.ces.dto.UserScoreNewResult;
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
    
    List<UserScoreNewResult> selectUserInfo(String name);
    
    List<UserScorePlayerResult> selectUserPlayer(String star);
    
    List<UserScoreNewResult> getUserGeneType(Map<String, String> map);
}