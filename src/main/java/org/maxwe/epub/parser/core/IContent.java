package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-26 09:44.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书目录对象
 */
public interface IContent {
    int getContentSize();
    LinkedList<INavigation> getNavigation();
    INavigation getNavigation(String navigationId);
    INavigation getNavigation(int index);

    /**
     * 提供根据导航对象定位到章节
     * @return
     */
    IChapter navigateTo(INavigation navigation) throws Exception;

    /**
     * 提供根据章节位置定位到章节
     * @return
     */
    IChapter navigateTo(String navigationId) throws Exception;

    /**
     * 提供根据章节位置定位到章节
     * @return
     */
    IChapter navigateTo(int index) throws Exception;
}
