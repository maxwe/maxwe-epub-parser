package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 13:26.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 导航节点
 */
public class NavPoint extends AXmlLabel {
    private String id;
    private String playOrder;
    private String title;
    private String href;
    private int level = 0;


    private LinkedList<NavPoint> subNavPoints = new LinkedList<NavPoint>();

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
                    if (XmlLabelName.TEXT.toString().equals(nodeName)) {
                    } else if (XmlLabelName.MANIFEST.toString().equals(nodeName)) {
                        this.title = this.xmlPullParser.nextText();
                    } else if (XmlLabelName.CONTENT.toString().equals(nodeName)) {
                        this.href = this.xmlPullParser.nextText();
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (XmlLabelName.PACKAGE.toString().equals(nodeName)) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayOrder() {
        return playOrder;
    }

    public void setPlayOrder(String playOrder) {
        this.playOrder = playOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LinkedList<NavPoint> getSubNavPoints() {
        return subNavPoints;
    }

    public void setSubNavPoints(LinkedList<NavPoint> subNavPoints) {
        this.subNavPoints = subNavPoints;
    }
}
