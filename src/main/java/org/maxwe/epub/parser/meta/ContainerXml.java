package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Pengwei Ding on 2015-08-28 23:20.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义EPub文件中的引导文件
 */
public class ContainerXml extends ADocumentParser {
    private final String path = "META-INF/container.xml";
    private final String defaultFileName = "content.opf";
    private String tocNcxPath;
    private String contentOpfPath;


    public ContainerXml(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
        pullParserFactory.setNamespaceAware(true);
        //获取XmlPullParser的实例
        XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
        xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        //设置输入流xml文件
        xmlPullParser.setInput(new FileReader(new File(this.documentPath)));

        int eventType = xmlPullParser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //文档开始
                case XmlPullParser.START_DOCUMENT:
                    break;
                //开始节点
                case XmlPullParser.START_TAG:
                    if (XmlLabelName.ROOTFILE.toString().equals(nodeName)) {
                        contentOpfPath = xmlPullParser.getAttributeValue(0);
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

    public String getOEBPSPath() {
        return this.contentOpfPath.replace(File.separator + this.defaultFileName,"");
    }

    public String getContentOpfPath() {
        return contentOpfPath;
    }

    public String getTocNcxPath() {
        return this.contentOpfPath.replace(this.defaultFileName,"toc.ncx");
    }
}
