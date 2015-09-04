package org.maxwe.epub.parser.core;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-28 17:38.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义图书段落对象操作方式
 */
public interface IParagraph {
    LinkedList<ISection> getSections();
}
