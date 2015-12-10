package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Created by Pengwei Ding on 2015-09-01 13:26.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 导航节点
 */
public class NavPoint extends AXmlLabelParser {
    private NavLabel navLabel;
    private Content content;
    private String id;
    private int playOrder;
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
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.ID.toString(), attributeName)) {
//                this.id = attributeValue;
                this.id = UUID.randomUUID().toString();
            } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.PLAYORDER.toString(), attributeName)) {
                this.playOrder = Integer.parseInt(attributeValue);
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.NAVLABEL.toString(), nodeName)) {
                        this.navLabel = new NavLabel(this.xmlPullParser);
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.CONTENT.toString(), nodeName)) {
                        this.content = new Content(xmlPullParser);
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.NAVPOINT.toString(), nodeName)) {
                        if (this.subNavPoints == null){
                            this.subNavPoints = new LinkedList<NavPoint>();
                        }
                        NavPoint subNavPoint = new NavPoint(this.xmlPullParser);
                        this.subNavPoints.add(subNavPoint);
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.NAVPOINT.toString(), nodeName)) {
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

    public int getPlayOrder() {
        return playOrder;
    }

    public LinkedList<NavPoint> getSubNavPoints() {
        return subNavPoints;
    }
}
