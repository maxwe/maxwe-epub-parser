package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
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
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.TITLE.toString(), attributeName)) {
                this.title = attributeValue;
            }else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.HREF.toString(), attributeName)) {
                this.href = attributeValue;
            }else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.TYPE.toString(), attributeName)) {
                this.type = attributeValue;
            }
        }
    }
}
