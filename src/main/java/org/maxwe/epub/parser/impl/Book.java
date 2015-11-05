package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.IBook;
import org.maxwe.epub.parser.core.IContent;
import org.maxwe.epub.parser.core.IMetadata;
import org.maxwe.epub.parser.meta.ContainerXml;
import org.maxwe.epub.parser.meta.ContentOpf;
import org.maxwe.epub.parser.meta.xml.Item;
import org.maxwe.epub.parser.meta.xml.Itemref;
import org.maxwe.epub.parser.meta.xml.Manifest;
import org.maxwe.epub.parser.meta.xml.Spine;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pengwei Ding on 2015-08-29 07:49.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description:
 */
public class Book extends ADocumentParser implements IBook {
    private IMetadata metadata;
    private IContent content;
    private Manifest manifest;
    private Spine spine;
    private LinkedList<SpineItem> spineItems;


    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    @Override
    protected void parser() throws Exception {
        ContainerXml containerXml = new ContainerXml(this.documentPath);
        ContentOpf contentOpf = new ContentOpf(containerXml.getContentOpfPath());
        this.metadata = contentOpf.buildMetadata();
        this.manifest = contentOpf.getaPackage().getManifest();
        this.spine = contentOpf.getaPackage().getSpine();
        this.spineItems = new LinkedList<SpineItem>();
        if (this.spineItems.size() == 0) {
            List<Itemref> itemrefs = this.spine.getItemrefs();
            for (int index = 0; index < itemrefs.size(); index++) {
                Item itemById = this.manifest.getItemById(itemrefs.get(index).getIdref());
                this.spineItems.add(new SpineItem(itemById.getId(), itemById.getHref(), index,containerXml.getOEBPSPath() + File.separator + itemById.getHref(), itemById.getMediaType()));
            }
        }
        this.content = new Content(containerXml.getTocNcxPath(), containerXml.getOEBPSPath());
    }

    public IMetadata getMetadata() {
        return this.metadata;
    }

    public IContent getContent() {
        return this.content;
    }

    public LinkedList<SpineItem> getSpineItems() {
        return this.spineItems;
    }
}
