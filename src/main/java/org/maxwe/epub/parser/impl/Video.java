package org.maxwe.epub.parser.impl;

import org.htmlparser.Tag;
import org.maxwe.epub.parser.core.AMediaSection;

/**
 * Created by Pengwei Ding on 2015-08-29 18:59.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Video extends AMediaSection {
    public Video(Tag tag) {
        super(tag);
    }

    @Override
    public String getMediaPath() {
        return super.getMediaPath();
    }
}
