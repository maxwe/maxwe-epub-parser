package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.constant.XmlLabelName;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by dingpengwei on 12/25/14.
 */
public class Package extends AXmlLabel {
    private String namespaces;
    private String version;
    private String uniqueIdentifier;
    private String prefix;
    private String xmlLang;
    private String id;
    private Metadata metadata;
    private Manifest manifest;
    private Spine spine;

    public Package(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (XmlLabelName.UNIQUE_IDENTIFIER.toString().equals(attributeName)) {
                this.uniqueIdentifier = attributeValue;
            } else if (XmlLabelName.VERSION.toString().equals(attributeName)) {
                this.version = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (XmlLabelName.METADATA.toString().equals(nodeName)) {
                        //metadata 的开始节点
                        this.metadata = new Metadata(xmlPullParser);
                    } else if (XmlLabelName.MANIFEST.toString().equals(nodeName)) {
                        //manifest 的开始节点
                        this.manifest = new Manifest(xmlPullParser);
                    } else if (XmlLabelName.SPINE.toString().equals(nodeName)) {
                        //spine 的开始节点
                        this.spine = new Spine(xmlPullParser);
                    } else if (XmlLabelName.GUIDE.toString().equals(nodeName)) {
                        //guide 的开始节点
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (XmlLabelName.PACKAGE.toString().equals(nodeName)) {
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

    public String getNamespaces() {
        return namespaces;
    }

    public String getVersion() {
        return version;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public String getId() {
        return id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Manifest getManifest() {
        return manifest;
    }

    public Spine getSpine() {
        return spine;
    }
}
