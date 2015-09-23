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
    private String parentId;
    private String title;
    private String href;
    private int level;
    private LinkedList<INavigation> subNavigations = new LinkedList<INavigation>();

    public Navigation(){}

    public Navigation(String id, String parentId, String title, String href) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LinkedList<INavigation> getSubNavigations() {
        return subNavigations;
    }

    public void print() {
        System.out.println("章节ID：" + this.getId());
        System.out.println("章节名：" + this.getTitle());
        System.out.println("章节路径：" + this.getHref());
    }
}
