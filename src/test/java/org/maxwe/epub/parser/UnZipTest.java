package org.maxwe.epub.parser;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Pengwei Ding on 2015-12-10 11:39.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class UnZipTest {

    public static void main(String[] args) throws Exception{

       // EPubParserUtils.unzip("/Users/dingpengwei/Desktop/epub/yangzhiqiu.epub","/Users/dingpengwei/Desktop/epub/yangzhiqiu/");

        long startTime=System.currentTimeMillis();
        try {
            ZipInputStream Zin=new ZipInputStream(new FileInputStream("/Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/ye1.epub"));//输入源zip路径
            BufferedInputStream Bin=new BufferedInputStream(Zin);
            String Parent="/Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/ye1"; //输出路径（文件夹目录）
            File Fout=null;
            ZipEntry entry;
            try {
                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){
                    Fout=new File(Parent,entry.getName());
                    if(!Fout.exists()){
                        (new File(Fout.getParent())).mkdirs();
                    }
                    FileOutputStream out=new FileOutputStream(Fout);
                    BufferedOutputStream Bout=new BufferedOutputStream(out);
                    int b;
                    while((b=Bin.read())!=-1){
                        Bout.write(b);
                    }
                    Bout.close();
                    out.close();
                    System.out.println(Fout+"解压成功");
                }
                Bin.close();
                Zin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("耗费时间： "+(endTime-startTime)+" ms");
    }
}
