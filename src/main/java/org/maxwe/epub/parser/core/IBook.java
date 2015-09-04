package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-28 17:35.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书对象操作方式
 */
public interface IBook {

    /**
     * 提供图书元数据
     * @return
     */
    IMetadata getMetadata();

    /**
     * 提供导航列表
     * @return
     */
    LinkedList<INavigation> getNavigations();

    /**
     * 提供某一个导航
     * @return
     */
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
    IChapter navigateTo(int index) throws Exception;


}
