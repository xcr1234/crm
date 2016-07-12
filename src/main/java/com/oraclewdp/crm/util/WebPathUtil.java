package com.oraclewdp.crm.util;

import java.io.File;
import java.net.URL;

/**
 * 这是项目中可能用到的路径帮助类，返回均为String类型，如果不存在返回null.
 * @author xcr
 */
public final class WebPathUtil {

	/**
	 * 获取WEB-INF/classes文件夹路径
	 * @author xcr
	 * @time 2016年7月12日 下午12:52:25
	 * @tags @return
	 */
    public static String getclassesPath(){
        URL url = WebPathUtil.class.getClassLoader().getResource("");
        if(url==null){
            return null;
        }
        return url.getFile();
    }


/**
 * 获取WEB-INF文件夹路径
 * @author xcr
 * @time 2016年7月12日 下午12:51:42
 * @tags @return
 */
    public static String getwebINFPath(){
        String classes = getclassesPath();
        if(classes==null){
            return null;
        }
        int i = classes.lastIndexOf('/');
        return classes.substring(0,i);
    }

    /**
     * 获取webRoot路径
     * @author xcr
     * @time 2016年7月12日 下午12:50:57
     * @tags @return
     */
    public static String getwebRoot(){
        String webINF = getwebINFPath();
        if(webINF==null){
            return null;
        }
        int i = webINF.lastIndexOf('/');
        return webINF.substring(0,i);
    }



}
