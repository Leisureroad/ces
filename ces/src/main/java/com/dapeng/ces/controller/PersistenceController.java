package com.dapeng.ces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dapeng.ces.dto.UserParam;
import com.dapeng.ces.dto.UserResult;
import com.dapeng.ces.dto.UserScorePlayerResult;
import com.dapeng.ces.model.Score;
import com.dapeng.ces.model.UserScore;
import com.dapeng.ces.service.persistence.PersistenceService;

@RestController
public class PersistenceController {
    @Autowired
    private PersistenceService persistenceService;
    
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
    
    @RequestMapping(value = "userCompare",method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public List<UserScorePlayerResult> userCompare(@RequestBody UserParam userParam){
//        List<String> list = new ArrayList<>();
//        list.add("rs1815739");
//        list.add("rs1803285");
//        list.add("rs8192678");
//        list.add("rs1799865");
        if(userParam == null){
            return null;
        }
        return persistenceService.userCompare(userParam.getUserName(), userParam.getList());
    }
}
