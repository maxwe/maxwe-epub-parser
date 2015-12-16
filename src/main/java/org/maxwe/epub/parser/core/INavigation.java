package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 11:03.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 导航对象，既单个图书目录对象
 */
public interface INavigation {
    String getId();
    int getPlayOrder();
    String getTitle();
    String getHref();
    String getOriginHref();
    LinkedList<INavigation> getSubNavigation();
    void print();
}
