package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 12/25/14.
 */
public class Identifier extends AXmlLabelParser {
    private String id;
    private String value;

    public Identifier(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
        int attributeCount = this.xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //解析属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.ID.toString(), attributeName)){
                this.id = attributeValue;
            }
        }
        this.value = this.xmlPullParser.nextText();
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
