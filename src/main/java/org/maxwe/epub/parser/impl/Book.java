package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.*;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 07:49.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description:
 */
public class Book extends ADocumentParser implements IBook {

    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {

    }

    public IMetadata getMetadata() {
        return null;
    }

    public LinkedList<INavigation> getNavigations() {
        return null;
    }

    public LinkedList<IChapter> getChapters() {
        return null;
    }

    public INavigation getNavigation(int index) {
        return null;
    }

    public IChapter getChapter(int index) {
        return null;
    }

    public IChapter navigateTo(INavigation navigation) {
        return null;
    }

    public IChapter navigateTo(int index) {
        return null;
    }
}
