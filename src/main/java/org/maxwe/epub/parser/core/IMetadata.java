package org.maxwe.epub.parser.core;

/**
 * Created by Pengwei Ding on 2015-08-29 17:09.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 定义了图书元数据实例应该提供的信息
 */
public interface IMetadata {
    String getISBN();
    String getIdentifier();
    String getBookName();
    String getAuthor();
    String getPublisher();
    String getLanguage();
    String getCreateTime();
    String getUpdateTime();
    String getCover();
    void print();
}
