package org.maxwe.epub.parser.core;

import org.htmlparser.Node;

/**
 * Created by Pengwei Ding on 2015-09-03 15:39.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: HTML标签解析器
 */
public abstract class AHtmlLabelParser {
    protected Node node;

    public AHtmlLabelParser(Node node) throws Exception {
        this.node = node;
        this.parser();
    }

    protected abstract void parser() throws Exception;
}
