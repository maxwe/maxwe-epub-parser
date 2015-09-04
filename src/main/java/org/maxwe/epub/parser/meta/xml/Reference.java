package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 1/29/15.
 */
public class Reference extends AXmlLabelParser {
    private String title;
    private String type;
    private String href;

    public Reference(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.TITLE.toString().equals(attributeName)){
                this.title = attributeValue;
            }else if (XmlLabelName.HREF.toString().equals(attributeName)) {
                this.href = attributeValue;
            } else if (XmlLabelName.TYPE.toString().equals(attributeName)) {
                this.type = attributeValue;
            }
        }
    }
}
