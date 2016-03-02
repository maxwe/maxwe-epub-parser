package org.maxwe.epub.parser;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Pengwei Ding on 2015-12-10 11:39.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class UnZipTest {

    public static void main(String[] args) throws Exception {

        // EPubParserUtils.unzip("/Users/dingpengwei/Desktop/epub/yangzhiqiu.epub","/Users/dingpengwei/Desktop/epub/yangzhiqiu/");

//        long startTime=System.currentTimeMillis();
//        try {
//            ZipInputStream Zin=new ZipInputStream(new FileInputStream("/Users/dingpengwei/workspace/ymepubreader-android/test/7.epub"));//输入源zip路径
//            BufferedInputStream Bin=new BufferedInputStream(Zin);
//            String Parent="/Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/ye2"; //输出路径（文件夹目录）
//            File Fout=null;
//            ZipEntry entry;
//            try {
//                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){
//                    Fout=new File(Parent,entry.getName());
//                    if(!Fout.exists()){
//                        (new File(Fout.getParent())).mkdirs();
//                    }
//                    FileOutputStream out=new FileOutputStream(Fout);
//                    BufferedOutputStream Bout=new BufferedOutputStream(out);
//                    int b;
//                    while((b=Bin.read())!=-1){
//                        Bout.write(b);
//                    }
//                    Bout.close();
//                    out.close();
//                    System.out.println(Fout+"解压成功");
//                }
//                Bin.close();
//                Zin.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        long endTime=System.currentTimeMillis();
//        System.out.println("耗费时间： "+(endTime-startTime)+" ms");

        List<String> stringList = new LinkedList<String>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("10");
        stringList.add("11");
        stringList.add("12");
        stringList.add("13");
        stringList.add("14");
        stringList.add("15");
        stringList.add("16");
        stringList.add("17");
        stringList.add("18");
        stringList.add("19");
        for (String string : stringList) {
            String epubFilePath = "/Users/dingpengwei/workspace/ymepubreader-android/test/" + string + ".epub";
            String outPathString = "/Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/test/ye" + string;
//            ZipInputStream inZip = new ZipInputStream(new FileInputStream("/Users/dingpengwei/workspace/ymepubreader-android/test/" + string + ".epub"));
//            ZipEntry zipEntry;
//            File file = null;
//            while ((zipEntry = inZip.getNextEntry()) != null && !zipEntry.isDirectory()) {
//                file = new File(outPathString, zipEntry.getName());
//                if (!file.exists()) {
//                    (new File(file.getParent())).mkdirs();
//                }
//                file.createNewFile();
//                System.out.println("解压：" + file.getAbsolutePath());
//                FileOutputStream out = new FileOutputStream(file);
//                int len;
//                byte[] buffer = new byte[1024 * 1024 * 5];
//                while ((len = inZip.read(buffer)) != -1) {
//                    out.write(buffer, 0, len);
//                    out.flush();
//                }
//                out.close();
//            }
//            inZip.close();

//            final int BUFFER = 2048;
//            try {
//                BufferedOutputStream dest = null;
//                FileInputStream fis = new FileInputStream(epubFilePath);
//                ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
//                ZipEntry entry;
//                while ((entry = zis.getNextEntry()) != null) {
//                    System.out.println("Extracting: " + entry);
//                    File file = new File(outPathString, entry.getName());
//                    if (!file.exists()) {
//                        (new File(file.getParent())).mkdirs();
//                    }
//                    int count;
//                    byte data[] = new byte[BUFFER];
//                    // write the files to the disk
//                    FileOutputStream fos = new FileOutputStream(file);
//                    dest = new
//                            BufferedOutputStream(fos, BUFFER);
//                    while ((count = zis.read(data, 0, BUFFER))
//                            != -1) {
//                        dest.write(data, 0, count);
//                    }
//                    dest.flush();
//                    dest.close();
//                }
//                zis.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            try {
                InputStream is = new FileInputStream(epubFilePath);
                String filename;
                ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
                ZipEntry ze;
                byte[] buffer = new byte[1024];
                int count;
                while ((ze = zis.getNextEntry()) != null) {
                    filename = ze.getName();
                    if (ze.isDirectory()) {
                        File fmd = new File(outPathString, filename);
                        fmd.mkdirs();
                        continue;
                    } else {
                        File fmd = new File(outPathString, filename);
                        String parent = fmd.getParentFile().getPath();
                        File fmd_1 = new File(parent);
                        fmd_1.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(outPathString , filename));
                    while ((count = zis.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, count);
                    }
                    fileOutputStream.close();
                    zis.closeEntry();
                }
                zis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
