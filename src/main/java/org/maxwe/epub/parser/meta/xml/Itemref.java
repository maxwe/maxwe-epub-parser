package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 1/28/15.
 */
public class Itemref extends AXmlLabelParser {

    private String idref;

    public Itemref(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.IDREF.toString(), attributeName)){
                this.idref = attributeValue;
            }
        }
    }

    public String getIdref() {
        return idref;
    }
}
