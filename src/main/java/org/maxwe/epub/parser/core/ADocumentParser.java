package org.maxwe.epub.parser.core;

/**
 * Created by Pengwei Ding on 2015-08-29 07:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 文件解析器
 */
public abstract class ADocumentParser {

    protected String documentPath;
    public ADocumentParser(String documentPath) throws Exception{
        this.documentPath = documentPath;
        this.parser();
    }
    protected abstract void parser() throws Exception;
}