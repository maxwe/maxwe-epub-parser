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
    /**
     * 标准的容器文件路径
     */
    private final String FILE_PATH = "META-INF/container.xml";
    /**
     * 默认的opf文件名称
     */
    private String defaultFileName = "content.opf";

    private String fullPath;
    private String OEBPSPath;
    private String OEBPSName;

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
        xmlPullParser.setInput(new FileReader(new File(this.pathLinker(this.documentPath,FILE_PATH))));

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
                        this.fullPath = xmlPullParser.getAttributeValue(0);
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

        int index = this.fullPath.lastIndexOf(File.separator);
        if (index < 0){
            this.OEBPSPath = "";
            this.OEBPSName = "";
            this.defaultFileName = this.fullPath;
        }else{
            this.OEBPSPath = this.fullPath.substring(0, index);
            this.OEBPSName = this.fullPath.substring(0, index);
            this.defaultFileName = this.fullPath.substring(index,this.fullPath.length());
        }
    }

    /**
     * 获取OEBPS目录的路径
     * @return OEBPS目录的绝对路径
     */
    public String getOEBPSPath() {
        return this.pathLinker(this.documentPath,this.OEBPSPath);
    }

    /**
     * 获取content.opf文件的路径
     * @return content.opf文件的绝对路径
     */
    public String getContentOpfPath() {
        return this.pathLinker(this.documentPath,this.fullPath);
    }

    /**
     * 获取toc.ncx文件的路径
     * 假设toc.ncx是和content.opf是在同一个目录
     * TODO 动态获取toc.ncx文件的路径
     * @return toc.ncx文件的绝对路径
     */
    public String getTocNcxPath() {
        return this.pathLinker(this.documentPath,this.fullPath.replace(this.defaultFileName,"toc.ncx"));
    }

    public String getOEBPSName() {
        return OEBPSName;
    }
}
