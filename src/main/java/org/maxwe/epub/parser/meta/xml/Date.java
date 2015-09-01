package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.core.ALabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-08-29 16:31.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Date extends ALabelParser {

    private String value;

    public Date(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = this.xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //解析属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);

        }
        this.value = this.xmlPullParser.nextText();
    }

    public String getValue() {
        return value;
    }
}
