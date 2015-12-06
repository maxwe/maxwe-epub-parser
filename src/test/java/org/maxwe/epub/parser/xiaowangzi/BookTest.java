package org.maxwe.epub.parser.xiaowangzi;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.maxwe.epub.parser.core.*;
import org.maxwe.epub.parser.impl.Book;
import org.maxwe.epub.parser.impl.SpineItem;
import org.maxwe.epub.parser.impl.Text;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 07:58.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书测试
 */
public class BookTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "xiaowangzi";

    @Before
    public void testExists(){
        if (new File(this.path).exists()) {

        }else{

        }
    }

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

            assertEquals("b686588b-958a-4ae8-bf36-3579086a0b0c", isbn);
            assertEquals("b686588b-958a-4ae8-bf36-3579086a0b0c", id);
            assertEquals("小王子", name);
            assertEquals("圣埃克苏佩里", author);
            assertEquals("UND", language);
            assertEquals("中国友谊出版社", publisher);
            assertEquals("2010-04-13 21:40:21.665000+08:00", createTime);
            assertEquals("1", cover);

        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetNavigations() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            LinkedList<INavigation> navigation = book.getContent().getNavigation();
            assertEquals(6, navigation.size());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetNavigation() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            INavigation iNavigation = book.getContent().getNavigation(4);
            assertEquals("index_split_003.html", iNavigation.getTitle());
            assertEquals(this.path + "/index_split_003.html", iNavigation.getHref());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testNavigateToByNavigation() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            INavigation navigation = book.getContent().getNavigation(3);
            IChapter iChapter = book.getContent().navigateTo(navigation);
            String title = iChapter.getTitle();
            LinkedList<IParagraph> paragraphs = iChapter.getParagraphs();
            assertEquals("��\\s�[P",title);
            assertEquals(316,paragraphs.size());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testNavigateToByIndex() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            IChapter iChapter = book.getContent().navigateTo(5);
            String title = iChapter.getTitle();
            LinkedList<IParagraph> paragraphs = iChapter.getParagraphs();
            IParagraph iParagraph = paragraphs.get(1);
            LinkedList<ISection> sections = iParagraph.getSections();
            ISection first = sections.getFirst();
            assertEquals("��\\s�[P", title);
            assertEquals("��s.~�\u007F�\n",((Text)first).getText());
        } else {
            assertFalse("测试文件不存在", true);
        }
    }

    @Test
    public void testGetSpineItem() throws Exception {
        if (new File(this.path).exists()) {
            Book book = new Book(this.path);
            LinkedList<SpineItem> spineItems = book.getSpineItems();
            for (SpineItem spineItem:spineItems){
                System.out.println(spineItem.toString());
            }
            assertFalse(false);
        } else {
            assertFalse("测试文件不存在", true);
        }
    }
}
