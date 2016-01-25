package org.maxwe.epub.parser.sample;

import junit.framework.TestCase;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Created by Pengwei Ding on 2015-12-21 14:56.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Test extends TestCase {

    public void testxxx() {
//        System.out.println(System.getProperty("user.dir"));//当前工作目录
//        String s = "public class Temp{";
//        s += "\r\n" + "      public static String call(String ss){      ";
//        s += "\r\n" + "            List<Integer> list = new ArrayList<Integer>(); ";
//        s += "\r\n" + "            list.add(\"dingpw\"); ";
//        s += "\r\n" + "            return \"return_str\"; ";
//        s += "\r\n" + "      }";
//        s += "\r\n" + "}";

        try {
//            File file = new File("Temp.java");
//            PrintWriter pw = new PrintWriter(new FileWriter(file));
//            //pw.println(s);
////            pw.write(s);
//            pw.close();

            //动态编译
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            int status = javac.run(null, null, null, "-d", System.getProperty("user.dir") + "/", "Temp.java");
            if (status != 0) {
                System.out.println("没有编译成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
