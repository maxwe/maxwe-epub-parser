package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingpengwei on 1/28/15.
 */
public class Spine extends AXmlLabelParser {
    private String toc;
    private List<Itemref> itemrefs;

    public Spine(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.TOC.toString(), attributeName)) {
                this.toc = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.ITEMREF.toString(), nodeName)) {
                        //itemrefs 的开始节点
                        if (this.itemrefs == null){
                            this.itemrefs = new LinkedList<Itemref>();
                        }
                        this.itemrefs.add(new Itemref(xmlPullParser));
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.SPINE.toString(), nodeName)) {
                        eventType = XmlPullParser.END_DOCUMENT;
                    }
                    break;
                default:
                    break;
            }
            if (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = xmlPullParser.next();
            }
        }
    }

    public String getToc() {
        return toc;
    }

    public List<Itemref> getItemrefs() {
        return itemrefs;
    }
}
