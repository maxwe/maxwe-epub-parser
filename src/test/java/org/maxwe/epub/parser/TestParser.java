package org.maxwe.epub.parser;

import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

/**
 * Created by Pengwei Ding on 2015-09-03 18:22.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TestParser extends NodeVisitor {

    public TestParser() {
    }

    public void visitTag(Tag tag) {
        System.out.println("--------------------");
    }



    public void visitStringNode(Text string) {
        System.out.println(string);
    }

    public static void main(String[] args) throws ParserException {
        String path = BookTest.class.getResource("/").getPath() + "sample";
        Parser parserHead = new Parser(path + "/OEBPS/Text/Copyright.xhtml");
        parserHead.setEncoding("UTF-8");
        parserHead.visitAllNodesWith(new TestParser());
        System.out.println("=============over============");
    }
}
