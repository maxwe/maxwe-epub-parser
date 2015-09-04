package org.maxwe.epub.parser.impl;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.NodeVisitor;
import org.maxwe.epub.parser.constant.HtmlLabelName;
import org.maxwe.epub.parser.core.ADocumentParser;
import org.maxwe.epub.parser.core.IChapter;
import org.maxwe.epub.parser.core.IParagraph;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-08-29 10:24.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 解析章节对象
 */
public class Chapter extends ADocumentParser implements IChapter {
    private String title;
    private String index;
    private String href;
    private LinkedList<IParagraph> paragraphs;

    public Chapter(String documentPath) throws Exception {
        super(documentPath);
        this.href = this.documentPath;
    }

    @Override
    protected void parser() throws Exception {
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
                    String text = string.getText();
                    if (this.byTitle && !"".equals(text.trim().replaceAll(System.getProperty("line.separator"), ""))){
                        title = text;
                    }
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
            Node paragraphNode = paragraphNodes.elementAt(j);
            Paragraph paragraph = new Paragraph(paragraphNode);
            if (paragraph.getSections() != null && !paragraph.getSections().isEmpty()) {
                if (this.paragraphs == null){
                    this.paragraphs = new LinkedList<IParagraph>();
                }
                this.paragraphs.add(paragraph);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getIndex() {
        return index;
    }

    public String getHref() {
        return href;
    }

    public LinkedList<IParagraph> getParagraphs() {
        return this.paragraphs;
    }

    public IParagraph getParagraph(int index) {
        return this.paragraphs.get(index);
    }
}

