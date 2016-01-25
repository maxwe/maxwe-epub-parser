package org.maxwe.epub.parser;

import junit.framework.TestCase;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Content;
import org.maxwe.epub.parser.meta.xml.Spine;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-12-08 13:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 兼容性测试
 */
public class CompatibilityTest extends TestCase {

    private static final String pathOfLiangjinyanyi = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zliangjinyanyi";
    private static final String pathOfChulianai = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zchulianai";
    private static final String pathOfYangzhiqiu = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zyangzhiqiu";
    private static final String pathOfJianai = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zjianai";
    private static final String pathOfMayunshuo = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zmayunshuo";
    private static final String pathOfZhangboling = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zhangboling";
    private static final String pathOfYueweicaotang = CompatibilityTest.class.getResource("/").getPath() + "compatibility/yueweicaotang";
    private static final String pathOfShucang = CompatibilityTest.class.getResource("/").getPath() + "compatibility/shucang";
    private static final String pathOfShenqidediqiu = CompatibilityTest.class.getResource("/").getPath() + "compatibility/shenqidediqiu";
    private static final String pathOfDaxuexiaoxun = CompatibilityTest.class.getResource("/").getPath() + "compatibility/daxuexiaoxun";
    private static final String pathOfCompatibility1 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility1";
    private static final String pathOfCompatibility2 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility2";
    private static final String pathOfCompatibility3 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility3";
    private static final String pathOfCompatibility4 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility4";
    private static final String pathOfCompatibility5 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility5";
    private static final String pathOfCompatibility6 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility6";
    private static final String pathOfCompatibility7 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility7";
    private static final String pathOfCompatibility8 = CompatibilityTest.class.getResource("/").getPath() + "compatibility/compatibility8";
    private static final String pathOfSample = CompatibilityTest.class.getResource("/").getPath() + "sample";
    private static final String pathOfZyisuo = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zyisuo";
    private static final String pathOfZengguofan = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zengguofan";

    private static final String pathOfZJinGangJing = CompatibilityTest.class.getResource("/").getPath() + "compatibility/zjingangjing";


    private static LinkedList<String> paths = new LinkedList<String>();

    static {
//        paths.add(pathOfLiangjinyanyi);
//        paths.add(pathOfChulianai);
//        paths.add(pathOfYangzhiqiu);
//        paths.add(pathOfJianai);
//        paths.add(pathOfMayunshuo);
//        paths.add(pathOfZhangboling);
//        paths.add(pathOfYueweicaotang);
//        paths.add(pathOfShucang);
//        paths.add(pathOfShenqidediqiu);
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
//        paths.add(pathOfZengguofan);
//        paths.add(pathOfZyisuo);
        paths.add(pathOfZJinGangJing);
    }

    public void testMain() throws Exception {
        for (String path : paths) {
            System.out.println("===========" + path + "===========");
            compatibility(path);
        }
    }

    private void compatibility(String path) throws Exception {
        if (new File(path).exists()) {
            EPubParser ePubParser = new EPubParser(path);
            Spine spine = ePubParser.getIOPF().getSpine();
            ePubParser.getMetadata().print();
            Content content = ePubParser.getContent();
            LinkedList<INavigation> navigations = content.getNavigation();
            System.out.println("章节数：" + navigations.size());
            for (INavigation navigation : navigations) {
                String href = navigation.getHref();
                if (href.contains("#")) {
                    href = href.substring(0, href.lastIndexOf("#"));
                }
                if (!new File(href).exists()) {
                    navigation.print();
                }
//                navigation.print();
                LinkedList<INavigation> subNavigations = navigation.getSubNavigation();
                if (subNavigations != null && subNavigations.size() > 0) {
                    for (INavigation subNav : subNavigations) {
                        String hrefSub = subNav.getHref();
                        if (hrefSub.contains("#")) {
                            hrefSub = hrefSub.substring(0, hrefSub.lastIndexOf("#"));
                        }
                        if (!new File(hrefSub).exists()) {
                            subNav.print();
                            new Throwable("上一行文件路径不存在");
                        }
//                        subNav.print();
                        LinkedList<INavigation> subNavigations1 = subNav.getSubNavigation();
                        if (subNavigations1 != null && subNavigations1.size() > 0) {
                            for (INavigation subOfSub : subNavigations) {
                                String hrefSubSub = subOfSub.getHref();
                                if (hrefSubSub.contains("#")) {
                                    hrefSubSub = hrefSubSub.substring(0, hrefSubSub.lastIndexOf("#"));
                                }
                                if (!new File(hrefSubSub).exists()) {
                                    subOfSub.print();
                                }
//                                subOfSub.print();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("测试文件不存在");
        }

        System.out.println("以上的输出如果出现了章节路径则表示该章节文件不存在");
    }

}
