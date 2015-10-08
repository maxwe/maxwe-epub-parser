package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 13:26.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 导航节点
 */
public class NavPoint extends AXmlLabelParser {
    private NavLabel navLabel;
    private Content content;
    private String id;
    private String playOrder;
    private LinkedList<NavPoint> subNavPoints;

    public NavPoint(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.ID.toString().equals(attributeName)) {
                this.id = attributeValue;
            } else if (XmlLabelName.PLAYORDER.toString().equals(attributeName)) {
                this.playOrder = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (XmlLabelName.NAVLABEL.toString().equals(nodeName)) {
                        this.navLabel = new NavLabel(this.xmlPullParser);
                    } else if (XmlLabelName.CONTENT.toString().equals(nodeName)) {
                        this.content = new Content(xmlPullParser);
                    }else if (XmlLabelName.NAVPOINT.toString().equals(nodeName)){
                        if (this.subNavPoints == null){
                            this.subNavPoints = new LinkedList<NavPoint>();
                        }
                        NavPoint subNavPoint = new NavPoint(this.xmlPullParser);
                        this.subNavPoints.add(subNavPoint);
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (XmlLabelName.NAVPOINT.toString().equals(nodeName)) {
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

    public NavLabel getNavLabel() {
        return navLabel;
    }

    public Content getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getPlayOrder() {
        return playOrder;
    }

    public LinkedList<NavPoint> getSubNavPoints() {
        return subNavPoints;
    }
}
