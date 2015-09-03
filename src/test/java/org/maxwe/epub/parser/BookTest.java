package org.maxwe.epub.parser;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.core.IMetadata;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Book;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 07:58.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书测试
 */
public class BookTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "sample";

    /**
     * 识别EPub元数据
     *
     * @throws Exception
     */
    @Test
    public void testGetMetadata() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            IMetadata metadata = book.getMetadata();
            String isbn = metadata.getIdentifier();
            String id = metadata.getIdentifier();
            String name = metadata.getBookName();
            String author = metadata.getAuthor();
            String language = metadata.getLanguage();
            String publisher = metadata.getPublisher();
            String createTime = metadata.getCreateTime();
            String cover = metadata.getCover();

            assertEquals("urn:uuid:b6c45774-b30c-4cb0-b518-f4e64836fa98", isbn);
            assertEquals("urn:uuid:b6c45774-b30c-4cb0-b518-f4e64836fa98", id);
            assertEquals("别随情绪做傻事", name);
            assertEquals("王云峰", author);
            assertEquals("zh-CN", language);
            assertEquals("中国戏剧出版社", publisher);
            assertEquals("2011-11-01", createTime);
            assertEquals("ds002161.jpg", cover);

        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetNavigations() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            LinkedList<INavigation> navigations = book.getNavigations();
            assertEquals(13, navigations.size());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetNavigation() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            INavigation iNavigation = book.getNavigations().get(7);
            assertEquals("第五章 闪开,让我歌唱小鬼们", iNavigation.getTitle());
            assertEquals(this.path + "/OEBPS/Text/ds00216106.xhtml", iNavigation.getHref());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetChapter() throws Exception {

    }

    @Test
    public void testNavigateToByNavigation() throws Exception {

    }

    @Test
    public void testNavigateToByIndex() throws Exception {

    }
}
