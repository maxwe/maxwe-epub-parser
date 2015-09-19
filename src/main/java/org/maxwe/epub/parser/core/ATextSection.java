package org.maxwe.epub.parser.core;

/**
 * Created by Pengwei Ding on 2015-09-01 15:39.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 无外链的ISection
 */
public abstract class ATextSection implements ISection {
    protected String text;
    public ATextSection(org.htmlparser.Text text){
        this.text = text.getText();
    }

    public String getText() {
        return text;
    }

    public int getLength(){
        if (text == null){
            return 0;
        }
        return this.text.length();
    }

    public String getWord(int index){
        if (text == null){
            return null;
        }
        char c = this.text.charAt(index);
        return String.valueOf(c);
    }
}
