package org.maxwe.epub.parser;

import java.io.File;

/**
 * Created by Pengwei Ding on 2015-12-09 19:11.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析器使用的工具集
 */
public class EPubParserUtils {

    /**
     * 路径链接
     * @param path1 前路径
     * @param path2 后路径
     * @return
     */
    public static String pathLinker(String path1,String path2){
        if ((path1 == null || path1.equals("")) && (path2 == null || path2.equals(""))){
            return null;
        }

        if (path1 == null || path1.equals("")){
            return path2;
        }

        if (path2 == null || path2.equals("")){
            return path1;
        }

        if (path1.endsWith(File.separator)){
            path1 = path1.substring(0,path1.length() - 1);
        }

        if (path2.startsWith(File.separator)){
            path2 = path2.substring(1,path2.length());
        }

        if (path2.endsWith(File.separator)){
            path2 = path2.substring(0,path2.length() - 1);
        }

        return path1 + File.separator + path2;
    }
}
