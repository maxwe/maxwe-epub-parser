package org.maxwe.epub.parser.sample;

import junit.framework.TestCase;

/**
 * Created by Pengwei Ding on 2015-09-01 20:09.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TocNcxTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "sample";

//    @Test
//    public void testGetOEBPSPath() throws Exception {
//        TocNcx tocNcx = new TocNcx(path + File.separator + "OEBPS/toc.ncx");
//        LinkedList<INavigation> navigations = tocNcx.getNavigations();
//        assertEquals(13, navigations.size());
//        INavigation iNavigation = navigations.get(3);
//        assertEquals("第一章 为什么老是有人说你少根筋", iNavigation.getTitle());
//    }
//
//    @Test
//    public void testGetMultiNavigation() throws Exception {
//        TocNcx tocNcx = new TocNcx(path + File.separator + "OEBPS/toc.ncx");
//        LinkedList<INavigation> navigations = tocNcx.getNavigations();
//        assertEquals(13,navigations.size());
//    }
//
//    @Test
//    public void testGetMultiNavigation2() throws Exception {
//        TocNcx tocNcx = new TocNcx(path + File.separator + "OEBPS/multi-toc.ncx");
////        TocNcx tocNcx = new TocNcx(path + File.separator + "OEBPS/toc.ncx");
//        LinkedList<INavigation> navigations = tocNcx.getNavigations("");
//        for (INavigation navigation:navigations){
//            navigation.print();
//        }
//        assertEquals(9,navigations.size());
//    }
}
