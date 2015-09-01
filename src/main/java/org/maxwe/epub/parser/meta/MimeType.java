package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.core.ADocumentParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Pengwei Ding on 2015-08-28 23:10.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义EPub文件标准的声明
 */
public class MimeType extends ADocumentParser {
    private final String fileName = "mimetype";
    private final String type = "application/epub+zip";

    private boolean result;
    public MimeType(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(this.documentPath)));
            String readLine = bufferedReader.readLine();
            if (type.equals(readLine)){
                result = true;
            }else{
                result = false;
            }
        }catch (IOException e){
            result = false;
        }finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
