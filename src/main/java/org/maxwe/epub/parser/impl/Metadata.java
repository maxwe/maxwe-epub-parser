package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.IMetadata;

/**
 * Created by Pengwei Ding on 2015-08-29 17:09.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Metadata implements IMetadata {

    private String ISBN;
    private String identifier;
    private String bookName;
    private String author;
    private String publisher;
    private String language;
    private String createTime;
    private String updateTime;
    private String cover;

    public Metadata() {
    }

    public Metadata(String ISBN, String identifier, String bookName, String author, String publisher, String language, String createTime, String updateTime, String cover) {
        this.ISBN = ISBN;
        this.identifier = identifier;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.cover = cover;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
