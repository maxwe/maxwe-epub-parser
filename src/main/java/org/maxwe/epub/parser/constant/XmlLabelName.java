package org.maxwe.epub.parser.constant;

/**
 * Created by Pengwei Ding on 2015-08-28 23:07.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 枚举EPub标准中XML文件中的标签名称
 */
public enum XmlLabelName {
    ROOTFILE("rootfile"),
    PACKAGE("package"),
    UNIQUE_IDENTIFIER("unique-identifier"),
    VERSION("version"),
    METADATA("metadata"),
    MANIFEST("manifest"),
    SPINE("spine"),
    GUIDE("guide"),
    DC_IDENTIFIER("dc:identifier"),
    DC_TITLE("dc:title"),
    DC_LANGUAGE("dc:language"),
    DC_CREATOR("dc:creator"),
    DC_PUBLISHER("dc:publisher"),
    DC_DATE("dc:date"),
    ITEM("item"),
    HREF("href"),
    MEDIA_TYPE("media-type"),
    ID("id"),
    REFERENCE("reference"),
    IDREF("idref"),
    TITLE("title"),
    TOC("toc"),
    TYPE("type"),
    ITEMREF("itemref"),
    META("meta"),
    NAVPOINT("navPoint"),
    PLAYORDER("playOrder"),
    NAVLABEL("navLabel"),
    TEXT("text"),
    NAVMAP("navMap"),
    CONTENT("content"),
    NCX("ncx"),
    SRC("src"),
    temp("temp");
























    private String value;
    XmlLabelName(String value){
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}
