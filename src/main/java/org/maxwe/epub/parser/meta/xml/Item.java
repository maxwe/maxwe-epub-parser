package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 1/28/15.
 */
public class Item extends AXmlLabelParser {

    private String id;
    private String href;
    private String mediaType;
    private String properties;

    public Item(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.ID.toString(), attributeName)){
                this.id = attributeValue;
            } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.HREF.toString(), attributeName)){
                this.href = attributeValue;
            } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.MEDIA_TYPE.toString(), attributeName)){
                this.mediaType = attributeValue;
            } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.PROPERTIES.toString(), attributeName)){
                this.properties = attributeValue;
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "id = " + this.getHref() + ", href = " + this.href + ", type = " + this.mediaType;
    }
}
