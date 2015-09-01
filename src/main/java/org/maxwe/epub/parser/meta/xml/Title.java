package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 12/26/14.
 */
public class Title extends AXmlLabel {

    private String id;
    private String xmlLang;
    private String value;

    public Title(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = this.xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //解析属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.ID.toString().equals(attributeName)) {
                this.id = attributeValue;
            }
        }
        this.value = this.xmlPullParser.nextText();
    }

    public String getId() {
        return id;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public String getValue() {
        return value;
    }
}