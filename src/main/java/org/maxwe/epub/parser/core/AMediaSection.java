package org.maxwe.epub.parser.core;

import org.htmlparser.Tag;
import org.maxwe.epub.parser.constant.HtmlLabelName;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 15:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 带外链的ISection
 */
public abstract class AMediaSection implements ISection {
    protected String documentPath;
    protected String mediaPath;

    public AMediaSection(String documentPath,Tag tag){
        this.documentPath = documentPath;
        this.mediaPath = tag.getAttribute(HtmlLabelName.SRC.toString());
    }

    public String getMediaPath() {
        /**
         * TODO 此处的处理的超级恶心
         */
        String[] documentSplits = this.documentPath.split("/");
        LinkedList<String> stringBuilder = new LinkedList<String>();
        for (String documentSplit:documentSplits){
            if (!"".equals(documentSplit)){
                stringBuilder.add("/" + documentSplit);
            }
        }

        stringBuilder.removeLast();

        String[] splits = this.mediaPath.split("/");
        for (String split:splits){
            if ("..".equals(split)){
                stringBuilder.removeLast();
            }else{
                stringBuilder.add("/" + split);
            }
        }

        this.mediaPath = "";
        for (String string:stringBuilder){
            this.mediaPath = mediaPath + string;
        }
        return mediaPath;
    }
}
