package com.dapeng.ces.service.persistence;

import java.util.List;
import java.util.Map;

import com.dapeng.ces.dto.UserCompareResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreDtoResult;
import com.dapeng.ces.model.NationalRanking;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.ScoreFemale;
import com.dapeng.ces.model.ScoreGroup;
import com.dapeng.ces.model.UserScore;

public interface PersistenceService {
    List<UserResult> saveUserGene();
    List<Score> saveScore();
    List<UserScore> saveUserScore();
    List<UserScoreDtoResult> getUserScore(String userName);
    List<UserCompareResult> userCompare(String userName,List<String> list);
    List<UserScoreDtoResult> getUserScoreType(String userName,String geneCode,String geneName);
    List<UserScoreDtoResult> getUserOriginalType(String userName,String geneCode,String geneName);
    List<NationalRanking> saveNationalRanking();
    Map<String, List<String>> subitemCompare(String userName);
    List<ScoreFemale> saveScoreFemale();
    Map<String, List<String>> subitemCompareGene(String userName);
    List<ScoreGroup> saveScoreGroup();
}
