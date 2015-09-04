package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.*;
import org.maxwe.epub.parser.meta.ContainerXml;
import org.maxwe.epub.parser.meta.ContentOpf;
import org.maxwe.epub.parser.meta.TocNcx;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 07:49.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description:
 */
public class Book extends ADocumentParser implements IBook {
    private Metadata metadata;
    private LinkedList<INavigation> navigations;

    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {
        ContainerXml containerXml = new ContainerXml(this.documentPath);
        ContentOpf contentOpf = new ContentOpf(containerXml.getContentOpfPath());
        TocNcx tocNcx = new TocNcx(containerXml.getTocNcxPath());
        this.metadata = contentOpf.getMetadata();
        this.navigations = tocNcx.getNavigations(containerXml.getOEBPSPath());
    }

    public IMetadata getMetadata() {
        return this.metadata;
    }

    public LinkedList<INavigation> getNavigations() {
        return this.navigations;
    }

    public INavigation getNavigation(int index) {
        return this.navigations.get(index);
    }

    public IChapter navigateTo(INavigation navigation) throws Exception {
        return new Chapter(navigation.getHref());
    }

    public IChapter navigateTo(int index) {
        return null;
    }
}
