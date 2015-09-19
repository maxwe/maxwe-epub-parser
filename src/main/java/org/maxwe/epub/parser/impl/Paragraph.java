package org.maxwe.epub.parser.impl;

import org.htmlparser.Node;
import org.htmlparser.Tag;
import org.htmlparser.visitors.NodeVisitor;
import org.maxwe.epub.parser.constant.HtmlLabelName;
import org.maxwe.epub.parser.core.AHtmlLabelParser;
import org.maxwe.epub.parser.core.IParagraph;
import org.maxwe.epub.parser.core.ISection;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-09-01 17:15.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Paragraph extends AHtmlLabelParser implements IParagraph {
    private LinkedList<ISection> sections;
    public Paragraph(String documentPath,Node node) throws Exception {
        super(documentPath,node);
    }

    @Override
    protected void parser() throws Exception {
        this.sections = new LinkedList<ISection>();
        this.node.accept(new NodeVisitor() {
            @Override
            public void visitTag(Tag tag) {
                if (HtmlLabelName.P.toString().equalsIgnoreCase(tag.getTagName())) {

                } else if (HtmlLabelName.A.toString().equalsIgnoreCase(tag.getTagName())) {

                } else if ((HtmlLabelName.IMG.toString().equalsIgnoreCase(tag.getTagName()))) {
                    sections.add(new Image(documentPath,tag));
                } else if ((HtmlLabelName.AUDIO.toString().equalsIgnoreCase(tag.getTagName()))) {
                    sections.add(new Audio(documentPath,tag));
                } else if ((HtmlLabelName.VIDEO.toString().equalsIgnoreCase(tag.getTagName()))) {
                    sections.add(new Video(documentPath,tag));
                }
            }

            @Override
            public void visitEndTag(Tag tag) {}

            @Override
            public void visitStringNode(org.htmlparser.Text string) {
                String text = string.getText();
                if (!"".equals(text.trim().replaceAll(System.getProperty("line.separator"), ""))) {
                    sections.add(new Text(string));
                }
            }
        });
    }

    public LinkedList<ISection> getSections() {
        return this.sections;
    }

    public ISection getSection(int index) {
        return this.sections.get(index);
    }

    public int getSectionLength() {
        return this.sections.size();
    }
}
