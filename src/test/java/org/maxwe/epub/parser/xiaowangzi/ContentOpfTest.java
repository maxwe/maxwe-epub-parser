package org.maxwe.epub.parser.xiaowangzi;

import junit.framework.TestCase;
import org.maxwe.epub.parser.sample.BookTest;

/**
 * Created by Pengwei Ding on 2015-09-01 19:33.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentOpfTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "xiaowangzi";

//    @Test
//    public void testGetMetadata() throws Exception{
//        OPF contentOpf = new OPF(path + File.separator + "content.opf");
//        Metadata metadata = contentOpf.buildMetadata();
//
//        String isbn = metadata.getIdentifier();
//        String id = metadata.getIdentifier();
//        String name = metadata.getBookName();
//        String author = metadata.getAuthor();
//        String language = metadata.getLanguage();
//        String publisher = metadata.getPublisher();
//        String createTime = metadata.getCreateTime();
//        String cover = metadata.getCover();
//
//
//        assertEquals("b686588b-958a-4ae8-bf36-3579086a0b0c", isbn);
//        assertEquals("b686588b-958a-4ae8-bf36-3579086a0b0c", id);
//        assertEquals("小王子", name);
//        assertEquals("圣埃克苏佩里", author);
//        assertEquals("UND", language);
//        assertEquals("中国友谊出版社", publisher);
//        assertEquals("2010-04-13 21:40:21.665000+08:00", createTime);
//        assertEquals("1", cover);
//    }
//
//    @Test
//    public void testGetManifest() throws Exception{
//        OPF contentOpf = new OPF(path + File.separator + "content.opf");
//        Manifest manifest = contentOpf.getaPackage().getManifest();
//        List<Item> items = manifest.getItems();
//        for(Item item:items){
//            System.out.println(item.toString());
//        }
//    }
}
