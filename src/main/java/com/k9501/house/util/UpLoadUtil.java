package com.k9501.house.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpLoadUtil {
    public static Map<String,Object> upLoad(MultipartRequest request,String path,String name){
        Map<String,Object> map=new HashMap<>();
        List<String> pathList=new ArrayList<>();
        try {
            //获取上传文件的集合
            List<MultipartFile> fileList = request.getFiles(name);
            //获取文件后缀名
            for (int i = 0;fileList!=null && i <fileList.size() ; i++) {
                MultipartFile file = fileList.get(i);
                String originalFilename = file.getOriginalFilename();
                String s=originalFilename.substring(originalFilename.lastIndexOf("."));
                String uuid= UUID.randomUUID().toString();
                String afterPath=new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss\\").format(new Date());
                String finalPath=path+afterPath;
                File file1=new File(finalPath);
                if (!file1.exists()){
                    file1.mkdirs();
                }
                file.transferTo(new File(finalPath+uuid+s));
                pathList.add(afterPath+uuid+s);
            }
            map.put("status",1);
            map.put("pathList",pathList);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            return map;
        }
    }
}
