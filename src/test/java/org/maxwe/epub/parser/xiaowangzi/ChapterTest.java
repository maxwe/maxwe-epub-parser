package org.maxwe.epub.parser.xiaowangzi;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.sample.BookTest;
import org.maxwe.epub.parser.core.IParagraph;
import org.maxwe.epub.parser.impl.Chapter;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-03 16:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ChapterTest extends TestCase {

    private String path = BookTest.class.getResource("/").getPath() + "xiaowangzi";

    @Test
    public void testGetNavigations() throws Exception {
        String path = this.path + "/index_split_000.html";
        Chapter chapter = new Chapter(path);
        String title = chapter.getTitle();
        String href = chapter.getHref();
        LinkedList<IParagraph> paragraphs = chapter.getParagraphs();

        assertEquals("��\\s�[P",title);
        assertEquals(path ,href);
    }
}
