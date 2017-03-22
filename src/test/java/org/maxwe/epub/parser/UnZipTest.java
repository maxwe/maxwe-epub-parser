package org.maxwe.epub.parser;

/**
 * Created by Pengwei Ding on 2015-12-10 11:39.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class UnZipTest {
    public static void main(String[] args) throws Exception {

//        long startTime=System.currentTimeMillis();
//
//        EPubParserUtils.unzip("/Users/dingpengwei/Downloads/wode.epub", "/Users/dingpengwei/Downloads/wode");


//        List<String> stringList = new LinkedList<String>();
//        stringList.add("1");
//        stringList.add("2");
//        stringList.add("3");
//        stringList.add("4");
//        stringList.add("5");
//        stringList.add("6");
//        stringList.add("7");
//        stringList.add("8");
//        stringList.add("9");
//        stringList.add("10");
//        stringList.add("11");
//        stringList.add("12");
//        stringList.add("13");
//        stringList.add("14");
//        stringList.add("15");
//        stringList.add("16");
//        stringList.add("17");
//        stringList.add("18");
//        stringList.add("19");
//        for (String string : stringList) {
//            String epubFilePath = "/Users/dingpengwei/Desktop/epub/dizigui.epub";
//            String outPathString = "/Users/dingpengwei/Desktop/epub/dizigui";
//            try {
//                InputStream is = new FileInputStream(epubFilePath);
//                String filename;
//                ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
//                ZipEntry ze;
//                byte[] buffer = new byte[1024];
//                int count;
//                while ((ze = zis.getNextEntry()) != null) {
//                    filename = ze.getName();
//                    if (ze.isDirectory()) {
//                        File fmd = new File(outPathString, filename);
//                        fmd.mkdirs();
//                        continue;
//                    } else {
//                        File fmd = new File(outPathString, filename);
//                        String parent = fmd.getParentFile().getPath();
//                        File fmd_1 = new File(parent);
//                        fmd_1.mkdirs();
//                    }
//                    FileOutputStream fileOutputStream = new FileOutputStream(new File(outPathString , filename));
//                    while ((count = zis.read(buffer)) != -1) {
//                        fileOutputStream.write(buffer, 0, count);
//                    }
//                    fileOutputStream.close();
//                    zis.closeEntry();
//                }
//                zis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//
//
//
//
//
//
//
//
//
//
// System.out.println("耗费时间： " + (endTime - startTime) + " ms");

    }
}
