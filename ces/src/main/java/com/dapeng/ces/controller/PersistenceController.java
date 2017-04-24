package com.dapeng.ces.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dapeng.ces.dto.UserCompareResult;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScoreDtoResult;
import com.dapeng.ces.model.NationalRanking;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.ScoreFemale;
import com.dapeng.ces.model.ScoreGroup;
import com.dapeng.ces.model.UserScore;
import com.dapeng.ces.service.persistence.PersistenceService;
import com.dapeng.ces.util.StringUtil;

@RestController
public class PersistenceController {
    @Autowired
    private PersistenceService persistenceService;
    @Value("${rsgene}")
    private String rsgene;
	
    @RequestMapping(value = "init",method = RequestMethod.GET,produces = "application/json")
    public boolean init(){
        persistenceService.saveUserGene();
        persistenceService.saveScore();
        persistenceService.saveScoreFemale();
        persistenceService.saveScoreGroup();
        persistenceService.saveUserScore();
        return true;
    }
    
    @RequestMapping(value = "saveUserGene",method = RequestMethod.GET,produces = "application/json")
    public List<UserResult> saveUserGene(){
        return persistenceService.saveUserGene();
    }
    
    @RequestMapping(value = "saveScore",method = RequestMethod.GET,produces = "application/json")
    public List<Score> saveScore(){
        return persistenceService.saveScore();
    }
    
    @RequestMapping(value = "saveUserScore",method = RequestMethod.GET,produces = "application/json")
    public List<UserScore> saveUserScore(){
        return persistenceService.saveUserScore();
    }
    
    @RequestMapping(value = "saveScoreFemale",method = RequestMethod.GET,produces = "application/json")
    public List<ScoreFemale> saveScoreFemale(){
        return persistenceService.saveScoreFemale();
    }
    
    @RequestMapping(value = "saveScoreGroup",method = RequestMethod.GET,produces = "application/json")
    public List<ScoreGroup> saveScoreGroup(){
        return persistenceService.saveScoreGroup();
    }
    
    @RequestMapping(value = "getUserScore",method = RequestMethod.GET,produces = "application/json")
    public List<UserScoreDtoResult> getUserScore(@RequestParam("userName") String userName){
         return persistenceService.getUserScore(userName);
//         return "成功导出用户：" + userName + "测试报告和数据！";
    }
    
    @RequestMapping(value = "userCompare",method = RequestMethod.GET,produces = "application/json")
    public List<UserCompareResult> userCompare(@RequestParam("userName") String userName){
        //获取对比的位点
        List<String> list = StringUtil.string2List(rsgene, ",");
        return persistenceService.userCompare(userName, list);
    }
    
    @RequestMapping(value = "saveNationalRanking",method = RequestMethod.GET,produces = "application/json")
    public List<NationalRanking> saveNationalRanking(){
        return persistenceService.saveNationalRanking();
    }
    
    @RequestMapping(value = "subitemCompare",method = RequestMethod.GET,produces = "application/json")
    public Map<String, List<String>> subitemCompare(String userName){
        return persistenceService.subitemCompare(userName);
    }
}
