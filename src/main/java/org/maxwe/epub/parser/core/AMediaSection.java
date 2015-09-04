package org.maxwe.epub.parser.core;

import org.htmlparser.Tag;
import org.maxwe.epub.parser.constant.HtmlLabelName;

/**
 * Created by Pengwei Ding on 2015-09-01 15:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 带外链的ISection
 */
public abstract class AMediaSection implements ISection {
    protected String mediaPath;

    public AMediaSection(Tag tag){
        this.mediaPath = tag.getAttribute(HtmlLabelName.SRC.toString());
    }

    public String getMediaPath() {
        return mediaPath;
    }
}
