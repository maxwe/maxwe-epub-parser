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
    private ContainerXml containerXml;
    private ContentOpf contentOpf;
    private TocNcx tocNcx;
    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {
        this.containerXml = new ContainerXml(this.documentPath);
        this.contentOpf = new ContentOpf(containerXml.getContentOpfPath());
        this.tocNcx = new TocNcx(containerXml.getTocNcxPath());
    }

    public IMetadata getMetadata() {
        return this.contentOpf.getMetadata();
    }

    public LinkedList<INavigation> getNavigations() {
        return this.tocNcx.getNavigations(this.containerXml.getOEBPSPath());
    }

    public INavigation getNavigation(int index) {
        return this.tocNcx.getNavigations().get(index);
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
