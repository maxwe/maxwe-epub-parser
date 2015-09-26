package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.IBook;
import org.maxwe.epub.parser.core.IContent;
import org.maxwe.epub.parser.core.IMetadata;
import org.maxwe.epub.parser.meta.ContainerXml;
import org.maxwe.epub.parser.meta.ContentOpf;

/**
 * Created by Pengwei Ding on 2015-08-29 07:49.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description:
 */
public class Book extends ADocumentParser implements IBook {
    private IMetadata metadata;
    private IContent content;

    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {
        ContainerXml containerXml = new ContainerXml(this.documentPath);
        ContentOpf contentOpf = new ContentOpf(containerXml.getContentOpfPath());
        this.metadata = contentOpf.getMetadata();
        this.content = new Content(containerXml.getTocNcxPath(),containerXml.getOEBPSPath());
    }

    public IMetadata getMetadata() {
        return this.metadata;
    }

    public IContent getContent() {
        return this.content;
    }
}
