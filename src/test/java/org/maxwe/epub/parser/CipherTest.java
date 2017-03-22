package org.maxwe.epub.parser;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.Key;
import java.util.Base64;

/**
 * Created by Pengwei Ding on 2016-06-07 09:07.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class CipherTest {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/ISO10126Padding";

    public static void main(String[] args) throws Exception {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.printf(Long.MAX_VALUE + "");
        System.out.println(Double.MAX_VALUE);


        Key secretKey = new SecretKeySpec("ymepub3554700623".getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        IvParameterSpec iv = new IvParameterSpec("ymepub3554700623".getBytes());

//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
//            ZipFile zipFile = new ZipFile("/Users/dingpengwei/Downloads/zhongwen.zip");
//            for (Enumeration<?> entries = zipFile.entries(); entries.hasMoreElements(); ) {
//                ZipEntry entry = ((ZipEntry) entries.nextElement());
//                String str = "/Users/dingpengwei/Downloads/zhongwen" + File.separator + entry.getName();
//                File desFile = new File(str);
//                if (entry.isDirectory()) {
//                    desFile.mkdirs();
//                } else {
//                    if (!desFile.exists()) {
//                        new File(desFile.getParentFile().getAbsolutePath()).mkdirs();
//                    }
//                    InputStream in = zipFile.getInputStream(entry);
//
//                    byte[] inputBytes = new byte[(int)entry.getSize()];
//                    int offset = 0;
//                    int numRead;
//                    while (offset < inputBytes.length && (numRead = in.read(inputBytes, offset, inputBytes.length - offset)) >= 0) {
//                        offset += numRead;
//                    }
//
//                    byte[] bytes = cipher.doFinal(inputBytes);
//                    byte[] encode = Base64.getEncoder().encode(bytes);
//
//                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
//                    bufferedWriter.write(new String(encode));
//                    bufferedWriter.flush();
//                    bufferedWriter.close();
//                    in.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

            File[] files = new File("/Users/dingpengwei/Downloads/zhongwen2/OEBPS/Text").listFiles();
            for (File file:files){
                FileInputStream inputStream = new FileInputStream(file);
                byte[] inputBytes = new byte[inputStream.available()];
                int offset = 0;
                int numRead;
                while (offset < inputBytes.length && (numRead = inputStream.read(inputBytes, offset, inputBytes.length - offset)) >= 0) {
                    offset += numRead;
                }
                byte[] outputBytes = cipher.doFinal(Base64.getDecoder().decode(inputBytes));
                String textString = new String(outputBytes);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath() + ".html")));
                bufferedWriter.write(textString);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
