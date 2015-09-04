package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 19:47.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class NavMap extends AXmlLabelParser {
    private LinkedList<NavPoint> navPoints;

    public NavMap(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (XmlLabelName.NAVPOINT.toString().equals(nodeName)){
                        if (this.navPoints == null){
                            this.navPoints = new LinkedList<NavPoint>();
                        }
                        this.navPoints.add(new NavPoint(this.xmlPullParser));
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (XmlLabelName.NAVMAP.toString().equals(nodeName)) {
                        eventType = XmlPullParser.END_DOCUMENT;
                    }
                    break;
                default:
                    break;
            }
            if (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = xmlPullParser.next();
            }
        }
    }

    public LinkedList<NavPoint> getNavPoints() {
        return navPoints;
    }
}
