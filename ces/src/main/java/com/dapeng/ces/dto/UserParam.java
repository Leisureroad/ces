package com.dapeng.ces.dto;

import java.util.List;

public class UserParam {
    private String userName;
    private List<String> list;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserParam [userName=");
        builder.append(userName);
        builder.append(", list=");
        builder.append(list);
        builder.append("]");
        return builder.toString();
    }
    
}
