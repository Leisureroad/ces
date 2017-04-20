package com.dapeng.ces.service.persistence;

import java.util.List;

import com.dapeng.ces.dto.UserCompareResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreNewResult;
import com.dapeng.ces.model.NationalRanking;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.UserScore;

public interface PersistenceService {
    List<UserResult> saveUserGene();
    List<Score> saveScore();
    List<UserScore> saveUserScore();
    List<UserScoreNewResult> getUserScore(String userName);
    List<UserCompareResult> userCompare(String userName,List<String> list);
    List<UserScoreNewResult> getUserGeneType(String userName,String geneCode,String geneName);
    List<NationalRanking> saveNationalRanking();
}
