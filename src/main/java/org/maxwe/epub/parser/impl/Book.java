package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.*;
import org.maxwe.epub.parser.meta.xml.Manifest;
import org.maxwe.epub.parser.meta.xml.Spine;

import java.util.LinkedList;

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
    private String OEBPSName;

    public Book(String documentPath) throws Exception {
        super(documentPath);
        this.parser();
    }

    protected void parser() throws Exception {
//        ContainerXml containerXml = new ContainerXml(this.documentPath);
//        this.OEBPSName = containerXml.getOEBPSName();
//        OPF contentOpf = new OPF(containerXml.getContentOpfPath());
//        this.metadata = contentOpf.buildMetadata();
//        this.manifest = contentOpf.getaPackage().getManifest();
//        this.spine = contentOpf.getaPackage().getSpine();
//        this.spineItems = new LinkedList<SpineItem>();
//        if (this.spineItems.size() == 0) {
//            List<Itemref> itemrefs = this.spine.getItemrefs();
//            for (int index = 0; index < itemrefs.size(); index++) {
//                Item itemById = this.manifest.getItemById(itemrefs.get(index).getIdref());
//                this.spineItems.add(new SpineItem(itemById.getId(), itemById.getHref(), index,containerXml.getOEBPSPath() + File.separator + itemById.getHref(), itemById.getMediaType()));
//            }
//        }
//        this.content = new Content(containerXml.getTocNcxPath(this.manifest.getNcxFileName()), containerXml.getOEBPSPath());
    }

    public IMetadata getMetadata() {
        return this.metadata;
    }

    /**
     * 在获取目录时候如果发现toc.ncx中无法获取就获取SpineItem对象集
     * @return
     */
    public IContent getContent() {
//        if (this.content.getNavigation() == null || this.content.getNavigation().size() == 0){
//            LinkedList<INavigation> navigations = new LinkedList<INavigation>();
//            for (SpineItem spineItem:this.spineItems){
//                Navigation navigation = new Navigation(spineItem.getId(), 0, spineItem.getHref(),this.pathLinker(this.documentPath, spineItem.getHref()));
//                navigations.add(navigation);
//            }
//            ((org.maxwe.epub.parser.impl.Content)(this.content)).setNavigates(navigations);
//        }
        return this.content;
    }

    public LinkedList<SpineItem> getSpineItems() {
        return this.spineItems;
    }

    public String getOEBPSName() {
        return this.OEBPSName;
    }
}
