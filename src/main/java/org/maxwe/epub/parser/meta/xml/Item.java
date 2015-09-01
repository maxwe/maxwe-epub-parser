package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 1/28/15.
 */
public class Item extends AXmlLabel {

    private String id;
    private String href;
    private String mediaType;

    public Item(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.ID.toString().equals(attributeName)){
                this.id = attributeValue;
            }else if (XmlLabelName.HREF.toString().equals(attributeName)) {
                this.href = attributeValue;
            } else if (XmlLabelName.MEDIA_TYPE.toString().equals(attributeName)) {
                this.mediaType = attributeValue;
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
}
