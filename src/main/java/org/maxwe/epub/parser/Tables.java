package org.maxwe.epub.parser;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.NodeVisitor;
import org.maxwe.epub.parser.constant.HtmlLabelName;

import java.util.LinkedHashMap;

/**
 * Created by Pengwei Ding on 2015-12-09 23:05.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Tables {
    private String documentPath;

    private LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>();

    public Tables(String documentPath) throws Exception{
        this.documentPath = documentPath;
        Parser chapterParser = new Parser(this.documentPath);
        chapterParser.setEncoding("UTF-8");
        /**
         * 解析第一个head
         */
        Node headNode = chapterParser.parse(new TagNameFilter(HtmlLabelName.HEAD.toString())).elementAt(0);
        NodeList headItems = headNode.getChildren();
        for (int j = 0; j < headItems.size(); j++) {
            Node headItem = headItems.elementAt(j);
            headItem.accept(new NodeVisitor(){
                private boolean byTitle;
                @Override
                public void visitTag(Tag tag) {
                    if (HtmlLabelName.TITLE.toString().equalsIgnoreCase(tag.getTagName())){
                        this.byTitle = true;
                    }
                }

                @Override
                public void visitEndTag(Tag tag) {
                    if (HtmlLabelName.TITLE.toString().equalsIgnoreCase(tag.getTagName())){
                        this.byTitle = false;
                    }
                }

                @Override
                public void visitStringNode(Text string) {
                }
            });
        }

        /**
         * 重置文档解析器
         */
        chapterParser.reset();

        /**
         * 解析第一个body
         */
        Node bodyNode = chapterParser.parse(new TagNameFilter(HtmlLabelName.BODY.toString())).elementAt(0);
        NodeList paragraphNodes = bodyNode.getChildren();
        for (int j = 0; j < paragraphNodes.size(); j++) {
            Node node = paragraphNodes.elementAt(j);
            node.accept(new NodeVisitor() {
                String attribute = null;
                @Override
                public void visitTag(Tag tag) {
                    if (HtmlLabelName.P.toString().equalsIgnoreCase(tag.getTagName())) {

                    } else if (HtmlLabelName.A.toString().equalsIgnoreCase(tag.getTagName())) {
                        attribute = tag.getAttribute(HtmlLabelName.HREF.toString());
                    } else if ((HtmlLabelName.IMG.toString().equalsIgnoreCase(tag.getTagName()))) {
                        tag.getAttribute(HtmlLabelName.SRC.toString());
                    } else if ((HtmlLabelName.AUDIO.toString().equalsIgnoreCase(tag.getTagName()))) {
                        tag.getAttribute(HtmlLabelName.AUDIO.toString());
                    } else if ((HtmlLabelName.VIDEO.toString().equalsIgnoreCase(tag.getTagName()))) {
                        tag.getAttribute(HtmlLabelName.VIDEO.toString());
                    }
                }

                @Override
                public void visitEndTag(Tag tag) {}

                @Override
                public void visitStringNode(org.htmlparser.Text string) {
                    String text = string.getText();
                    if (!"".equals(text.trim().replaceAll(System.getProperty("line.separator"), ""))) {
                        linkedHashMap.put(attribute,text);
                    }
                }
            });
        }
    }


    public LinkedHashMap<String, String> getLinkedHashMap() {
        return linkedHashMap;
    }
}
