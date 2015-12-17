package org.maxwe.epub.parser.core;

/**
 * Created by Pengwei Ding on 2015-08-28 17:35.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义EPub对象操作方式
 */
public interface IEPub {

    /**
     * 提供图书元数据
     * @return
     */
    IMetadata getMetadata();

    /**
     * 提供图书目录
     * @return
     */
    IContent getContent();


}
