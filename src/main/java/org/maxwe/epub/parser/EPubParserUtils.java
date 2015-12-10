package org.maxwe.epub.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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


    /**
     * 标价标签是否是相同
     * @param xmlLabel1 解析标签
     * @param xmlLabel2 解析标签
     * @return
     */
    public static boolean xmlLabelEquals(boolean strict,String xmlLabel1,String xmlLabel2){
        if (xmlLabel1 == null || xmlLabel2 == null){
            return false;
        }
        if (strict){
            if (xmlLabel1.equalsIgnoreCase(xmlLabel2) ){
                return true;
            }
        }else{
            if (xmlLabel1.equalsIgnoreCase(xmlLabel2)){
                return true;
            }
            if (xmlLabel1.contains(xmlLabel2)){
                return true;
            }
            if (xmlLabel2.contains(xmlLabel1)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param epubPath
     * @param descDir
     * @throws Exception
     */
    public static void unzip(String epubPath,String descDir) throws Exception{
        if (!descDir.endsWith(File.separator)){
            descDir = descDir + File.separator;
        }
        File pathFile = new File(descDir);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(epubPath);
        for(Enumeration entries = zip.entries();entries.hasMoreElements();){
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if(!file.exists()){
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if(new File(outPath).isDirectory()){
                continue;
            }
            //输出文件路径信息
            System.out.println(outPath);

            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while((len=in.read(buf1))>0){
                out.write(buf1,0,len);
            }
            in.close();
            out.close();
        }
    }
}
