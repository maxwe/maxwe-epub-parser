package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Pengwei Ding on 2015-08-28 23:20.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析EPub文件中的引导文件
 */
public class ContainerXml implements IContainer {
    /**
     * content.opf文件的相对全路径
     */
    private String relativeFullPath;
    /**
     * content.opf文件所在的相对目录
     */
    private String relativeFullPathDir;
    /**
     * content.opf文件名
     */
    private String OPFFileName;


    public ContainerXml(String documentPath) throws Exception {
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
        pullParserFactory.setNamespaceAware(true);
        //获取XmlPullParser的实例
        XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
        xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        //设置输入流xml文件
        FileInputStream fileInputStream = new FileInputStream(new File(documentPath));
        xmlPullParser.setInput(fileInputStream, "utf-8");

        int eventType = xmlPullParser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //文档开始
                case XmlPullParser.START_DOCUMENT:
                    break;
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(true,XmlLabelName.ROOTFILE.toString(), nodeName)) {
                        this.relativeFullPath = xmlPullParser.getAttributeValue(0);
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

        int index = this.relativeFullPath.lastIndexOf(File.separator);
        if (index < 0) {
            /**
             * 如果不包含File.separator
             * full-path参数中就只能是文件名称
             */
            this.relativeFullPathDir = "/";
            this.OPFFileName = this.relativeFullPath;
        } else {
            this.relativeFullPathDir = this.relativeFullPath.substring(0,index);
            this.OPFFileName = this.relativeFullPath.substring(index + 1, this.relativeFullPath.length());
        }
    }

    public String getRelativeFullPath() {
        return relativeFullPath;
    }

    public String getRelativeFullPathDir() {
        return this.relativeFullPathDir;
    }

    public String getOPFFileName() {
        return OPFFileName;
    }
}
