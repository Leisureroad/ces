package com.dapeng.ces.service.persistence;

import java.util.List;

import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScorePlayerResult;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.UserScore;

public interface PersistenceService {
    List<UserResult> saveUserGene();
    List<Score> saveScore();
    List<UserScore> saveUserScore();
    List<UserScorePlayerResult> userCompare(String userName,List<String> list);
}
