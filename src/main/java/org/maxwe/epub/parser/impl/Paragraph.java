package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ALabelParser;
import org.maxwe.epub.parser.core.IParagraph;
import org.maxwe.epub.parser.core.ISection;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 17:15.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Paragraph extends ALabelParser implements IParagraph {
    public Paragraph(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {

    }

    public void parser(XmlPullParser xmlPullParser) throws Exception {

    }

    public LinkedList<ISection> getSections() {
        return null;
    }
}
