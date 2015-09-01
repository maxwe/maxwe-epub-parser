package org.maxwe.epub.parser.meta.xml;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-08-29 14:17.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义EPub中xml文件的标签
 */
public abstract class AXmlLabel {
    protected XmlPullParser xmlPullParser;

    public AXmlLabel(XmlPullParser xmlPullParser) throws Exception {
        this.xmlPullParser = xmlPullParser;
        this.parser();
    }

    protected abstract void parser() throws Exception;
}
