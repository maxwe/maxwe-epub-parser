package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.IChapter;
import org.maxwe.epub.parser.core.IContent;
import org.maxwe.epub.parser.core.INavigation;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-26 09:50.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Content implements IContent {
    private LinkedList<INavigation> navigates;

    public Content(LinkedList<INavigation> navigates){
        this.navigates = navigates;
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
        INavigation navigation = null;
        for (INavigation nav:this.navigates){
            if (nav.getId().equals(navigationId)){
                navigation = nav;
                break;
            }
        }
        return navigateTo(navigation);
    }

    public IChapter navigateTo(int index) throws Exception {
        return navigateTo(this.navigates.get(index));
    }
}
