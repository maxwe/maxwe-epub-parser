package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 11:03.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书目录对象操作方式
 */
public interface INavigation {

    String getId();
    String getParentId();
    String getTitle();
    String getHref();
    int getLevel();
    LinkedList<INavigation> getSubNavigations();
    void print();

}
