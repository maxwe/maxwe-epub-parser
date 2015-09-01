package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.ALabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-09-01 13:27.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class NavLabel extends ALabelParser {
    private Text text;

    public NavLabel(XmlPullParser xmlPullParser) throws Exception {
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
                    if (XmlLabelName.TEXT.toString().equals(nodeName)) {
                        this.text = new Text(xmlPullParser);
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

    public Text getText() {
        return text;
    }
}
