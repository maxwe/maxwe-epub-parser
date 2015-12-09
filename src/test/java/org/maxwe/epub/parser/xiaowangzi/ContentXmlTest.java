package org.maxwe.epub.parser.xiaowangzi;

import junit.framework.TestCase;
import org.junit.Test;
import org.maxwe.epub.parser.meta.ContentOpf;
import org.maxwe.epub.parser.meta.xml.Manifest;
import org.maxwe.epub.parser.sample.BookTest;
import org.maxwe.epub.parser.meta.ContainerXml;

import java.io.File;

/**
 * Created by Pengwei Ding on 2015-09-01 18:42.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentXmlTest extends TestCase {
    private String path = BookTest.class.getResource("/").getPath() + "xiaowangzi";

    @Test
    public void testGetOEBPSPath() throws Exception{
        ContainerXml containerXml = new ContainerXml(path);
        String oebpsPath = containerXml.getOEBPSPath();
        assertEquals(this.path,oebpsPath);
    }

    @Test
    public void testGetContentOpfPath() throws Exception{
        ContainerXml containerXml = new ContainerXml(path);
        String contentOpfPath = containerXml.getContentOpfPath();
        assertEquals(this.path + File.separator + "content.opf",contentOpfPath);
    }

    @Test
    public void testGetTocNcxPath() throws Exception{
        ContainerXml containerXml = new ContainerXml(path);
        ContentOpf contentOpf = new ContentOpf(containerXml.getContentOpfPath());
        Manifest manifest = contentOpf.getaPackage().getManifest();
        String tocNcxPath = containerXml.getTocNcxPath(manifest.getNcxFileName());
        assertEquals(this.path + File.separator + "toc.ncx",tocNcxPath);
    }
}
