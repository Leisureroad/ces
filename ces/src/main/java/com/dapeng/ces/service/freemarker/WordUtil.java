package com.dapeng.ces.service.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @Desc：word操作工具类
 * @Author：张轮
 * @Date：2014-1-22下午05:03:19
 */
public class WordUtil {
   
	@SuppressWarnings("unchecked")
	public static void createWord(Map dataMap,String templateName,String filePath,String fileName){
        try {
        //创建配置实例 
        Configuration configuration = new Configuration();
        
        //设置编码
            configuration.setDefaultEncoding("UTF-8");
            
            //ftl模板文件统一放至 com.lun.template 包下面
            configuration.setClassForTemplateLoading(WordUtil.class,"/template");
            
            //获取模板 
            Template template = configuration.getTemplate(templateName);
            
            //输出文件
            File outFile = new File(filePath+File.separator+fileName);
            
            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }
            
            //将模板和数据模型合并生成文件 
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));


            //生成文件
            template.process(dataMap, out);
            
            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


