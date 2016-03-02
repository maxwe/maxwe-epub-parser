package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-28 17:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书章节对象操作方式
 */
public interface IChapter {
    /**
     * 章节在图书中的顺序
     * @return
     */
    int getIndex();

    /**
     * 章节标题
     * @return
     */
    String getTitle();

    /**
     * 章节的文件链接
     * @return
     */
    String getHref();

    /**
     * 章节下的段落集合
     * @return
     */
    LinkedList<IParagraph> getParagraphs();

    /**
     * 章节下的段落获取
     * @param index
     * @return
     */
    IParagraph getParagraph(int index);

    /**
     * 章节下的段落个数
     * @return
     */
    int getParagraphLength();
}
