package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.impl.Metadata;
import org.maxwe.epub.parser.meta.xml.Package;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Pengwei Ding on 2015-08-28 23:22.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义EPub文件中的资源配置
 */
public class ContentOpf extends ADocumentParser {
    private Package aPackage;

    public ContentOpf(String documentPath) throws Exception {
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
                    if (XmlLabelName.PACKAGE.toString().equals(nodeName)) {
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
        org.maxwe.epub.parser.meta.xml.Metadata orginMetadata = this.aPackage.getMetadata();
        return new Metadata(
                orginMetadata.getDcIdentifier().getFirst().getValue(),
                orginMetadata.getDcIdentifier().getFirst().getValue(),
                orginMetadata.getDcTitle().getFirst().getValue(),
                orginMetadata.getDcCreator().getFirst().getValue(),
                orginMetadata.getDcPublisher().getFirst().getValue(),
                orginMetadata.getDcLanguage().getFirst().getValue(),
                orginMetadata.getDcDate().getFirst().getValue(),
                orginMetadata.getDcDate().getFirst().getValue(),
                orginMetadata.getMetas().getFirst().getValue());
    }
}
