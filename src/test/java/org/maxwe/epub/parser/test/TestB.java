package org.maxwe.epub.parser.test;

/**
 * Created by Pengwei Ding on 2015-12-25 09:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TestB {

    private String name;

    public TestB() {
        super();
    }

    public TestB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println("=======name is " + this.getName() + "=========");
        return super.toString();
    }
}
