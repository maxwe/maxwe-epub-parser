package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.core.ALabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-09-01 19:48.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Content extends ALabelParser {

    private String value;

    public Content(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {

    }

    public String getValue() {
        return value;
    }
}