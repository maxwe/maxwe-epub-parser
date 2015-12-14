package org.maxwe.epub.parser.compatibility;

import org.maxwe.epub.parser.EPubParser;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Content;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-12-08 13:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
///Users/dingpengwei/workspace/dingpw/maxwe-epub-parser/target/test-classes/compatibility/compatibility4/OEBPS/toc.ncx
public class Compatibility {
    private static final String pathOfYangzhiqiu = Compatibility.class.getResource("/").getPath() + "compatibility/zyangzhiqiu";
    private static final String pathOfJianai = Compatibility.class.getResource("/").getPath() + "compatibility/zjianai";
    private static final String pathOfMayunshuo = Compatibility.class.getResource("/").getPath() + "compatibility/zmayunshuo";
    private static final String pathOfZhangboling = Compatibility.class.getResource("/").getPath() + "compatibility/zhangboling";
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
    private static final String pathOfSample = Compatibility.class.getResource("/").getPath() + "sample";
    private static LinkedList<String> paths = new LinkedList<String>();

    static {
//        paths.add(pathOfYangzhiqiu);
//        paths.add(pathOfJianai);
//        paths.add(pathOfMayunshuo);
//        paths.add(pathOfZhangboling);
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
//        paths.add(pathOfSample);
    }

    public static void main(String[] args) throws Exception {
        for (String path : paths) {
            System.out.println("===========" + path + "===========");
            testCompatibility(path);
        }
    }

    private static void testCompatibility(String path) throws Exception {
        if (new File(path).exists()) {
            EPubParser ePubParser = new EPubParser(path);
            ePubParser.getMetadata().print();
            Content content = ePubParser.getContent();
            LinkedList<INavigation> navigations = content.getNavigation();
            System.out.println("章节数：" + navigations.size());
            for (INavigation navigation:navigations){
                String href = navigation.getHref();
                if (href.contains("#")){
                    href = href.substring(0, href.lastIndexOf("#"));
                }
                if (!new File(href).exists()){
                    navigation.print();
                }
                navigation.print();
                LinkedList<INavigation> subNavigations = navigation.getSubNavigations();
                if (subNavigations != null && subNavigations.size() > 0){
                    for (INavigation subNav:subNavigations){
                        String hrefSub = subNav.getHref();
                        if (hrefSub.contains("#")){
                            hrefSub = hrefSub.substring(0, hrefSub.lastIndexOf("#"));
                        }
                        if (!new File(hrefSub).exists()){
                            subNav.print();
                        }
                        LinkedList<INavigation> subNavigations1 = subNav.getSubNavigations();
                        if (subNavigations1 != null && subNavigations1.size() > 0){
                            for (INavigation subOfSub:subNavigations){
                                String hrefSubSub = subOfSub.getHref();
                                if (hrefSubSub.contains("#")){
                                    hrefSubSub = hrefSubSub.substring(0, hrefSubSub.lastIndexOf("#"));
                                }
                                if (!new File(hrefSubSub).exists()){
                                    subOfSub.print();
                                }
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
