package com.oraclewdp.crm.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xcr
 * 上传文件的工具类 支持多个文件上传。
 */
public class FileUpload {

	/**
	 * 随机生成新的文件名并返回。
	 * @author xcr
	 * @time 2016年7月12日 下午12:55:18
	 * @tags @param request
	 * @tags @param path 目录
	 * @tags @return  List<String>
	 * @tags @throws Exception
	 */
    public static List<String> upload(HttpServletRequest request,String path) throws Exception {
        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            List<String> names = new ArrayList<>();
            for(FileItem fileItem:fileItems){

                String fileName=fileItem.getName();//获得文件名，包括路径
                if(fileName!=null){
                    File fullFile=new File(fileItem.getName());
                    String name = getFileName(fullFile.getName());
                    File savedFile=new File(WebPathUtil.getwebRoot(),name);
                    fileItem.write(savedFile);

                    names.add(name);


                }
            }
            return names;



        }

        return null;



    }

    private static String getFileName(String fileName){
        //随机生成文件名.
        int i = fileName.lastIndexOf('.');
        String ext = null;
        if(i==-1){
            //这个文件没有扩展名
            ext = "";
        }else{
            ext = fileName.substring(i);
        }
        String uuid = UUID.randomUUID().toString();
        return uuid+ext;

    }



}
