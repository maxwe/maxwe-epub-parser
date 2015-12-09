package org.maxwe.epub.parser.compatibility;

import org.maxwe.epub.parser.core.IMetadata;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Book;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-12-08 13:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
///Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/target/test-classes/compatibility/compatibility4/OEBPS/toc.ncx
public class Compatibility {
    private static final String pathOfYueweicaotang = Compatibility.class.getResource("/").getPath() + "compatibility/yueweicaotang";
    private static final String pathOfShucang = Compatibility.class.getResource("/").getPath() + "compatibility/shucang";
    private static final String pathOfShenqidediqiu = Compatibility.class.getResource("/").getPath() + "compatibility/shenqidediqiu";
    private static final String pathOfDaxuexiaoxun = Compatibility.class.getResource("/").getPath() + "compatibility/daxuexiaoxun";
    private static final String pathOfCompatibility1 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility1";
    private static final String pathOfCompatibility2 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility2";
    private static final String pathOfCompatibility3 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility3";
    private static final String pathOfCompatibility4 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility4";
    private static final String pathOfCompatibility5 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility5";
    private static final String pathOfCompatibility6 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility6";
    private static final String pathOfCompatibility7 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility7";
    private static final String pathOfCompatibility8 = Compatibility.class.getResource("/").getPath() + "compatibility/compatibility8";
    private static LinkedList<String> paths = new LinkedList<String>();
    static{
//        paths.add(pathOfYueweicaotang);
//        paths.add(pathOfShucang);
        paths.add(pathOfShenqidediqiu);
//        paths.add(pathOfDaxuexiaoxun);
//        paths.add(pathOfCompatibility1);
//        paths.add(pathOfCompatibility2);
//        paths.add(pathOfCompatibility3);
//        paths.add(pathOfCompatibility4);
//        paths.add(pathOfCompatibility5);
//        paths.add(pathOfCompatibility6);
//        paths.add(pathOfCompatibility7);
//        paths.add(pathOfCompatibility8);
    }
    public static void main(String[] args) throws Exception{
        for (String path:paths){
            System.out.println("===========" + path + "===========");
            testCompatibility(path);
        }
    }
    private static void testCompatibility(String path) throws Exception{
        if (new File(path).exists()) {
            Book book = new Book(path);
            IMetadata metadata = book.getMetadata();
            metadata.print();
            LinkedList<INavigation> navigations = book.getContent().getNavigation();
            System.out.println("章节数：" + navigations.size());
            for (INavigation navigation:navigations){
                navigation.print();
                LinkedList<INavigation> subNavigations = navigation.getSubNavigations();
                if (subNavigations != null && subNavigations.size() > 0){
                    for (INavigation subNav:subNavigations){
                        subNav.print();
                        LinkedList<INavigation> subNavigations1 = subNav.getSubNavigations();
                        if (subNavigations1 != null && subNavigations1.size() > 0){
                            for (INavigation subOfSub:subNavigations){
                                subOfSub.print();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("测试文件不存在");
        }
    }

}
