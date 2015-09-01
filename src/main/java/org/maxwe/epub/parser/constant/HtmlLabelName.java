package org.maxwe.epub.parser.constant;

/**
 * Created by Pengwei Ding on 2015-08-29 22:55.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public enum HtmlLabelName {
    HTML("html"),
    HEAD("head"),
    TITLE("title"),
    BODY("BODY"),
    P("p"),
    SPAN("span"),
    IMG("img"),
    AUDIO("audio"),
    VIDEO("video"),
    ALT("alt"),
    SRC("src"),
    temp1(""),
    temp3("");


    private String value;
    HtmlLabelName(String value){
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}