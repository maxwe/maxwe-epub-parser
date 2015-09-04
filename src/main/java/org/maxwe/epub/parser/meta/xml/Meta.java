package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-08-29 16:26.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析meta
 */
public class Meta extends AXmlLabelParser {

    /**
     * meta的name属性的值
     */
    private String type;
    /**
     * meta的content属性的值
     */
    private String value;

    public Meta(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = this.xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //解析属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if ("name".equals(attributeName)){
                this.type = attributeValue;
            }
            if ("content".equals(attributeName)){
                this.value = attributeValue;
            }
        }
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
