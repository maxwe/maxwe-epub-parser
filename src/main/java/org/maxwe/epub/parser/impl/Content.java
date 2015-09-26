package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.IChapter;
import org.maxwe.epub.parser.core.IContent;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.meta.TocNcx;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-26 09:50.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Content extends ADocumentParser implements IContent {
    private LinkedList<INavigation> navigates;

    public Content(String documentPath,String OEBPSPath) throws Exception {
        super(documentPath);
        TocNcx tocNcx = new TocNcx(this.documentPath);
        this.navigates = tocNcx.getNavigations(OEBPSPath);
    }

    @Override
    protected void parser() throws Exception {


    }

    public int getContentSize() {
        return this.navigates.size();
    }

    public LinkedList<INavigation> getNavigation() {
        return this.navigates;
    }

    public INavigation getNavigation(String navigationId) {
        INavigation navigation = null;
        for (INavigation nav:this.navigates){
            if (nav.getId().equals(navigationId)){
                navigation = nav;
                break;
            }
        }
        return navigation;
    }

    public INavigation getNavigation(int index) {
        return this.navigates.get(index);
    }

    public IChapter navigateTo(INavigation navigation) throws Exception {
        return new Chapter(navigation.getHref());
    }

    public IChapter navigateTo(String navigationId) throws Exception {
        return null;
    }

    public IChapter navigateTo(int index) throws Exception {
        return new Chapter(this.navigates.get(index).getHref());
    }
}
