package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingpengwei on 1/29/15.
 */
public class Guide extends AXmlLabel {
    private List<Reference> references;
    public Guide(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (XmlLabelName.REFERENCE.toString().equals(nodeName)) {
                        //itemrefs 的开始节点
                        if (this.references == null){
                            this.references = new LinkedList<Reference>();
                        }
                        this.references.add(new Reference(xmlPullParser));
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (XmlLabelName.GUIDE.toString().equals(nodeName)) {
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

    public List<Reference> getReferences() {
        return references;
    }
}
