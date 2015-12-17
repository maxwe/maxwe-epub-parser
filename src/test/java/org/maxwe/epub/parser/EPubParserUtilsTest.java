package org.maxwe.epub.parser;

import junit.framework.TestCase;

import java.io.File;

/**
 * Created by Pengwei Ding on 2015-12-09 19:16.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPubParserUtilsTest extends TestCase {

    public void testPathLinker() throws Exception {
        String assertResult = "a" + File.separator + "b" + File.separator + "c" + File.separator + "d" + File.separator + "e" + File.separator + "f";

        String path1_1 = "a" + File.separator + "b" + File.separator + "c";
        String path1_2 = "d" + File.separator + "e" + File.separator + "f";
        String pathLinker1 = EPubParserUtils.pathLinker(path1_1, path1_2);
        assertEquals (assertResult,pathLinker1);


        String path2_1 = "a" + File.separator + "b" + File.separator + "c" + File.separator + "";
        String path2_2 = "d" + File.separator + "e" + File.separator + "f";
        String pathLinker2 = EPubParserUtils.pathLinker(path2_1, path2_2);
        assertEquals (assertResult,pathLinker2);


        String path3_1 = "a" + File.separator + "b" + File.separator + "c" + File.separator + "";
        String path3_2 = "d" + File.separator + "e" + File.separator + "f"  + File.separator + "";
        String pathLinker3 = EPubParserUtils.pathLinker(path3_1, path3_2);
        assertEquals (assertResult,pathLinker3);


        String path4_1 = "a" + File.separator + "b" + File.separator + "c" + File.separator + "";
        String path4_2 = File.separator + "d" + File.separator + "e" + File.separator + "f"  + File.separator + "";
        String pathLinker4 = EPubParserUtils.pathLinker(path4_1, path4_2);
        assertEquals (assertResult,pathLinker4);


        String path5_1 = "a" + File.separator + "b" + File.separator + "c";
        String path5_2 = File.separator + "d" + File.separator + "e" + File.separator + "f"  + File.separator + "";
        String pathLinker5 = EPubParserUtils.pathLinker(path5_1, path5_2);
        assertEquals (assertResult,pathLinker5);


        String path6_1 = null;
        String path6_2 = File.separator + "d" + File.separator + "e" + File.separator + "f"  + File.separator + "";
        String pathLinker6 = EPubParserUtils.pathLinker(path6_1, path6_2);
        assertEquals (path6_2,pathLinker6);

        String path7_1 = "a" + File.separator + "b" + File.separator + "c";
        String path7_2 = null;
        String pathLinker7 = EPubParserUtils.pathLinker(path7_1, path7_2);
        assertEquals (path7_1,pathLinker7);

    }
}
