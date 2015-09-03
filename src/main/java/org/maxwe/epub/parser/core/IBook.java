package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-28 17:35.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书对象操作方式
 */
public interface IBook {

    IMetadata getMetadata();
    LinkedList<INavigation> getNavigations();

    INavigation getNavigation(int index);
    IChapter getChapter(int index);

    IChapter navigateTo(INavigation navigation);
    IChapter navigateTo(int index);


}
