package org.maxwe.epub.parser.xiaowangzi;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.sample.BookTest;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.meta.TocNcx;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 20:09.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TocNcxTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "xiaowangzi";

    @Test
    public void testGetOEBPSPath() throws Exception {
        TocNcx tocNcx = new TocNcx(path + File.separator + "toc.ncx");
        LinkedList<INavigation> navigations = tocNcx.getNavigations();
        assertEquals(0, navigations.size());
    }

    @Test
    public void testGetMultiNavigation() throws Exception {
        TocNcx tocNcx = new TocNcx(path + File.separator + "toc.ncx");
        LinkedList<INavigation> navigations = tocNcx.getNavigations();
        assertEquals(0,navigations.size());
    }
}
