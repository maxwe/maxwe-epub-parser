package org.maxwe.epub.parser;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.NodeVisitor;
import org.maxwe.epub.parser.constant.HtmlLabelName;

import java.util.LinkedHashMap;

/**
 * Created by Pengwei Ding on 2015-12-09 23:05.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析HTML中的导航文件，本版本的解析把树形的导航变更为线性导航
 */
public class Tables {
    private String documentPath;

    private LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>();

    private boolean flag = false;

    public Tables(String documentPath) throws Exception{
        this.documentPath = documentPath;
        Parser chapterParser = new Parser(this.documentPath);
        chapterParser.setEncoding("UTF-8");
        Node bodyNode = chapterParser.parse(new TagNameFilter(HtmlLabelName.BODY.toString())).elementAt(0);

        NodeList paragraphNodes = bodyNode.getChildren();
        for (int j = 0; j < paragraphNodes.size(); j++) {
            Node node = paragraphNodes.elementAt(j);
            node.accept(new NodeVisitor() {
                String attribute = null;
                @Override
                public void visitTag(Tag tag) {
                    if (HtmlLabelName.NAV.toString().equalsIgnoreCase(tag.getTagName())) {
                        String attribute = tag.getAttribute(HtmlLabelName.EPUB_TYPE.toString());
                        System.out.println(attribute);
                        if ("toc".equalsIgnoreCase(attribute)){
                            flag = true;
                        }
                    } else if (HtmlLabelName.A.toString().equalsIgnoreCase(tag.getTagName())) {
                        if (flag){
                            attribute = tag.getAttribute(HtmlLabelName.HREF.toString());
                        }
                    }
                }

                @Override
                public void visitEndTag(Tag tag) {
                    if (HtmlLabelName.NAV.toString().equalsIgnoreCase(tag.getTagName())) {
                        flag = false;
                    }
                }

                @Override
                public void visitStringNode(org.htmlparser.Text string) {
                    if (flag){
                        String text = string.getText();
                        if (!"".equals(text.trim().replaceAll(System.getProperty("line.separator"), ""))) {
                            if (attribute != null){
                                linkedHashMap.put(attribute,text);
                            }
                        }
                    }
                }
            });
        }
    }


    public LinkedHashMap<String, String> getLinkedHashMap() {
        return linkedHashMap;
    }
}
