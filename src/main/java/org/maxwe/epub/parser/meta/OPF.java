package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.meta.xml.*;
import org.maxwe.epub.parser.meta.xml.Package;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Pengwei Ding on 2015-08-28 23:22.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析EPub文件中的OPF资源文件
 */
public class OPF implements IOPF {

    private Package aPackage;

    public OPF(String documentPath) throws Exception {
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
        pullParserFactory.setNamespaceAware(true);
        //获取XmlPullParser的实例
        XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
        xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        //设置输入流xml文件
        xmlPullParser.setInput(new FileReader(new File(documentPath)));

        int eventType = xmlPullParser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //文档开始
                case XmlPullParser.START_DOCUMENT:
                    break;
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.PACKAGE.toString(), nodeName)){
                        this.aPackage = new Package(xmlPullParser);
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    break;
                default:
                    break;

            }
            eventType = xmlPullParser.next();
        }
    }

    public Metadata getMetadata() {
        return this.aPackage.getMetadata();
    }

    public Manifest getManifest() {
        return this.aPackage.getManifest();
    }

    public Spine getSpine() {
        return this.aPackage.getSpine();
    }

    public Guide getGuide() {
        return null;
    }

    public String getNavigationFilePath() {
        String key = this.getSpine() == null ? null : this.getSpine().getToc();
        if (key == null) {
            key = "ncx";
        }
        return this.getManifest().getItemById(key) == null ? null : this.getManifest().getItemById(key).getHref();
    }

    public String getNavigationHtmlPath() {
        String key = this.getSpine() == null ? null : this.getSpine().getToc();
        if (key == null) {
            key = "toc";
        }
        String s = this.getManifest().getItemById(key) == null ? null : this.getManifest().getItemById(key).getHref();
        if (s.endsWith("html") || s.endsWith("xhtml")) {
            return s;
        } else {
            return null;
        }
    }
}
