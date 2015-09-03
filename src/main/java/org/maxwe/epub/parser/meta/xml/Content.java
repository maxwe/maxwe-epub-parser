package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
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
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.SRC.toString().equals(attributeName)) {
                this.value = attributeValue;
            }
        }
    }

    public String getValue() {
        return value;
    }
}
