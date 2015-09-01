package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-28 17:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书章节对象操作方式
 */
public interface IChapter {
    String getId();

    String getIndex();

    String getTitle();

    String getHref();

    INavigation getNavigation();

    LinkedList<IParagraph> getParagraphs();

    IParagraph getParagraph(int index);
}
