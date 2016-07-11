package com.oraclewdp.crm.util;

import java.io.File;
import java.net.URL;

/**
 *
 * 获取web项目中各种路径
 *
 * 主要方法如下：
 *
 * 获取WEB-INF/classes文件夹路径
 * WebPathUtil.classes();
 *
 * 获取WEB-INF文件夹路径
 * WebPathUtil.webINF();
 *
 *
 * 获取webRoot路径
 * WebPathUtil.webRoot();
 *
 *
 * 返回均为String类型，如果不存在返回null.
 *
 *
 * @author xcr
 */
public final class WebPathUtil {

    public static String classes(){
        URL url = WebPathUtil.class.getClassLoader().getResource("");
        if(url==null){
            return null;
        }
        return url.getFile();
    }



    public static String webINF(){
        String classes = classes();
        if(classes==null){
            return null;
        }
        int i = classes.lastIndexOf('/');
        return classes.substring(0,i);
    }

    public static String webRoot(){
        String webINF = webINF();
        if(webINF==null){
            return null;
        }
        int i = webINF.lastIndexOf('/');
        return webINF.substring(0,i);
    }



}
