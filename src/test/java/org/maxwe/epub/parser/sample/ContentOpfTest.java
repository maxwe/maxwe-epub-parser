package org.maxwe.epub.parser.sample;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.meta.OPF;

import java.io.File;

/**
 * Created by Pengwei Ding on 2015-09-01 19:33.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentOpfTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "sample";

    @Test
    public void testGetMetadata() throws Exception{
        OPF contentOpf = new OPF(path + File.separator + "OEBPS/content.opf");
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
//        assertEquals("urn:uuid:b6c45774-b30c-4cb0-b518-f4e64836fa98", isbn);
//        assertEquals("urn:uuid:b6c45774-b30c-4cb0-b518-f4e64836fa98", id);
//        assertEquals("别随情绪做傻事",name);
//        assertEquals("王云峰",author);
//        assertEquals("zh-CN",language);
//        assertEquals("中国戏剧出版社",publisher);
//        assertEquals("2011-11-01",createTime);
//        assertEquals("ds002161.jpg",cover);
    }

    @Test
    public void testGetManifest() throws Exception{
//        OPF contentOpf = new OPF(path + File.separator + "OEBPS/content.opf");
//        Manifest manifest = contentOpf.getaPackage().getManifest();
//        List<Item> items = manifest.getItems();
//        for(Item item:items){
//            System.out.println(item.toString());
//        }
    }
}
