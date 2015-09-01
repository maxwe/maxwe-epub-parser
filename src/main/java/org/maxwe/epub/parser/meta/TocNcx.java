package org.maxwe.epub.parser.meta;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Navigation;
import org.maxwe.epub.parser.meta.xml.NavPoint;
import org.maxwe.epub.parser.meta.xml.Ncx;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 19:40.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析导航的配置
 */
public class TocNcx extends ADocumentParser {

    private Ncx ncx;

    public TocNcx(String documentPath) throws Exception {
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
                    if (XmlLabelName.NAVMAP.toString().equals(nodeName)) {
                        this.ncx = new Ncx(xmlPullParser);
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

    public LinkedList<INavigation> getNavigations(){
        LinkedList<INavigation> navigations = new LinkedList<INavigation>();
        LinkedList<NavPoint> navPoints = this.ncx.getNavMap().getNavPoints();
        for (NavPoint navPoint:navPoints){
            navigations.add(new Navigation(navPoint.getId(), navPoint.getId(), navPoint.getNavLabel().getText().getValue(), navPoint.getContent().getValue()));
        }
        return navigations;
    }

}
