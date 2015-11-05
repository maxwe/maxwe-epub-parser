package org.maxwe.epub.parser.impl;

import org.maxwe.epub.parser.core.ISpineItem;

/**
 * Created by Pengwei Ding on 2015-10-19 11:58.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class SpineItem implements ISpineItem {

    private String id;
    private String href;
    private int index;
    private String url;
    private String mediaType;

    public SpineItem() {
    }

    public SpineItem(String id, String href, int index, String url, String mediaType) {
        this.id = id;
        this.href = href;
        this.index = index;
        this.url = url;
        this.mediaType = mediaType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return "file://" + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "SpineItem{" +
                "id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", index=" + index +
                ", url='" + url + '\'' +
                ", mediaType='" + mediaType + '\'' +
                '}';
    }
}
