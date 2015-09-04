package org.maxwe.epub.parser.meta.xml;

import org.maxwe.epub.parser.core.AXmlLabelParser;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Pengwei Ding on 2015-09-01 19:48.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Text extends AXmlLabelParser {
    private String value;

    public Text(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        this.value = xmlPullParser.nextText();
    }

    public String getValue() {
        return value;
    }
}
