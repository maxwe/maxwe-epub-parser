package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ALabelParser;
import org.maxwe.epub.parser.core.ITextSection;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-08-29 18:59.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Text extends ALabelParser implements ITextSection{
    public Text(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {

    }

    public String getText() {
        return null;
    }
}
