package org.maxwe.epub.parser;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.core.IParagraph;
import org.maxwe.epub.parser.impl.Chapter;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-03 16:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ChapterTest extends TestCase {

    private String path = BookTest.class.getResource("/").getPath() + "sample";

    @Test
    public void testGetNavigations() throws Exception {
        String path = this.path + "/OEBPS/Text/Copyright.xhtml";
        Chapter chapter = new Chapter(path);
        String title = chapter.getTitle();
        String href = chapter.getHref();
        LinkedList<IParagraph> paragraphs = chapter.getParagraphs();

        assertEquals("版权页",title);
        assertEquals(path ,href);
        assertEquals(8,paragraphs.size());
    }
}
