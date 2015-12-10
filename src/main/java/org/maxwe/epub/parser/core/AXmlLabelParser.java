package org.maxwe.epub.parser.core;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-09-01 17:03.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: XML标签解析器
 */
public abstract class AXmlLabelParser {
    protected XmlPullParser xmlPullParser;

    public AXmlLabelParser(XmlPullParser xmlPullParser) throws Exception {
        this.xmlPullParser = xmlPullParser;
        this.parser();
    }



    protected abstract void parser() throws Exception;
}
