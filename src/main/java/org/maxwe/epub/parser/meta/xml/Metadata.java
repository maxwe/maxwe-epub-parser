package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.EPubParserUtils;
import org.maxwe.epub.parser.constant.XmlLabelName;
import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by dingpengwei on 12/16/14.
 */
public class Metadata extends AXmlLabelParser {
    /**
     * 图书的唯一标记
     */
    private LinkedList<Identifier> dcIdentifier;

    /**
     * 即图书的名称
     */
    private LinkedList<Title> dcTitle;

    /**
     * 语言
     */
    private LinkedList<Language> dcLanguage;

    /**
     * 图书作者
     */
    private LinkedList<Creator> dcCreator;

    /**
     * 出版社
     */
    private LinkedList<Publisher> dcPublisher;

    private LinkedList<Date> dcDate;

    private LinkedList<Meta> metas;


    public Metadata(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_IDENTIFIER.toString(), nodeName)) {
                        //dc:identifier的开始节点
                        if (this.dcIdentifier == null) {
                            this.dcIdentifier = new LinkedList<Identifier>();
                        }
                        this.dcIdentifier.add(new Identifier(xmlPullParser));
                        System.out.println();
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_TITLE.toString(), nodeName)) {
                        //dc:title的开始节点
                        if (this.dcTitle == null) {
                            this.dcTitle = new LinkedList<Title>();
                        }
                        this.dcTitle.add(new Title(xmlPullParser));
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_LANGUAGE.toString(), nodeName)) {
                        //dc:language的开始节点
                        if (this.dcLanguage == null) {
                            this.dcLanguage = new LinkedList<Language>();
                        }
                        this.dcLanguage.add(new Language(xmlPullParser));
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_CREATOR.toString(), nodeName)) {
                        if (this.dcCreator == null) {
                            this.dcCreator = new LinkedList<Creator>();
                        }
                        this.dcCreator.add(new Creator(xmlPullParser));
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_PUBLISHER.toString(), nodeName)) {
                        if (this.dcPublisher == null) {
                            this.dcPublisher = new LinkedList<Publisher>();
                        }
                        this.dcPublisher.add(new Publisher(xmlPullParser));
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.DC_DATE.toString(), nodeName)) {
                        if (this.dcDate == null) {
                            this.dcDate = new LinkedList<Date>();
                        }
                        this.dcDate.add(new Date(xmlPullParser));
                    } else if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.META.toString(), nodeName)) {
                        if (this.metas == null) {
                            this.metas = new LinkedList<Meta>();
                        }
                        this.metas.add(new Meta(xmlPullParser));
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (EPubParserUtils.xmlLabelEquals(false,XmlLabelName.METADATA.toString(), nodeName)) {
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

    public LinkedList<Identifier> getDcIdentifier() {
        return dcIdentifier;
    }

    public LinkedList<Title> getDcTitle() {
        return dcTitle;
    }

    public LinkedList<Language> getDcLanguage() {
        return dcLanguage;
    }

    public LinkedList<Creator> getDcCreator() {
        return dcCreator;
    }

    public LinkedList<Publisher> getDcPublisher() {
        return dcPublisher;
    }

    public LinkedList<Date> getDcDate() {
        return dcDate;
    }

    public LinkedList<Meta> getMetas() {
        return metas;
    }
}
