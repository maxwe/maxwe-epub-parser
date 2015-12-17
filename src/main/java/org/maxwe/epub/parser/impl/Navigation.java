package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.INavigation;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 11:06.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Navigation implements INavigation {
    private String id;
    private int playOrder;
    private String title;
    private String href;
    private String originHref;
    private LinkedList<INavigation> subNavigation = new LinkedList<INavigation>();

    public Navigation(){}

    public Navigation(String id,int playOrder, String title, String href,String originHref) {
        this.id = id;
        this.playOrder = playOrder;
        this.title = title;
        this.href = href;
        this.originHref = originHref;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlayOrder() {
        return playOrder;
    }

    public void setPlayOrder(int playOrder) {
        this.playOrder = playOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public LinkedList<INavigation> getSubNavigation() {
        return subNavigation;
    }

    public String getOriginHref() {
        return originHref;
    }

    public void setOriginHref(String originHref) {
        this.originHref = originHref;
    }

    public void print() {
        System.out.println("章节ID：" + this.getId());
        System.out.println("章节顺序：" + this.getPlayOrder());
        System.out.println("章节名：" + this.getTitle());
        System.out.println("章节路径：" + this.getHref());
        System.out.println("章节相对路径：" + this.getOriginHref());
    }
}
