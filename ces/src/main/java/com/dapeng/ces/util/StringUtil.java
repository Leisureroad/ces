package com.dapeng.ces.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    /**
     * 
     * <b>功能描述:将List转化为对应的字符串，以compart分割</b>
     * <p>
     * <pre></pre>
     * @author 陈亚东
     * @version 创建时间： 2016-11-3
     */
    public static String list2String(List<String> str, String compart) {
        if (str == null || str.isEmpty() || compart == null) {
            return null;
        }
        StringBuffer builder = new StringBuffer();
        for (int i = 0;i<str.size();i++) {
            String subStr = str.get(i).toString();
            builder.append(subStr).append(compart);
        }
        String result = builder.toString();
        return result.substring(0, result.lastIndexOf(compart));
    }
    /**
     * 
     * <b>功能描述:将Str以regex分割为对应的List</b>
     * <p>
     * <pre></pre>
     * @author 陈亚东
     * @version 创建时间： 2011-12-5上午10:58:11
     */
    public static List<String> string2List(String str, String regex) {
        List<String> resultList = new ArrayList<>();
        if (str == null || "".equals(str)) {
            return resultList;
        }
        String[] result = str.split(regex);
        for (int i = 0; i < result.length; i++) {
            resultList.add(result[i]);
        }
        return resultList;
    }
}
