package org.maxwe.epub.parser.core;

import java.io.File;

/**
 * Created by Pengwei Ding on 2015-08-29 07:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 文件解析器
 */
public abstract class ADocumentParser {

    protected String documentPath;
    public ADocumentParser(String documentPath) throws Exception{
        this.documentPath = documentPath;
    }

    protected String pathLinker(String path1,String path2){
        if ("".equals(path2) || "\\".equals(path2)){
            return path1;
        }else{
            return path1 + File.separator + path2;
        }
    }
}
