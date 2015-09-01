package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.IChapter;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.core.IParagraph;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 10:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Chapter extends ADocumentParser implements IChapter {

    public Chapter(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {

    }

    public String getId() {
        return null;
    }

    public String getIndex() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public String getHref() {
        return null;
    }

    public INavigation getNavigation() {
        return null;
    }

    public LinkedList<IParagraph> getParagraphs() {
        return null;
    }

    public IParagraph getParagraph(int index) {
        return null;
    }
}
