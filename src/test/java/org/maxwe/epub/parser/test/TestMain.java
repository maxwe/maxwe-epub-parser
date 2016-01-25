package org.maxwe.epub.parser.test;

import java.lang.reflect.Field;

/**
 * Created by Pengwei Ding on 2015-12-25 09:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TestMain extends TestA {

    public void test() throws Exception {
        Field testB = TestA.class.getDeclaredField("testB");
        testB.toString();
    }

    public static void main(String[] args) throws Exception{
        TestMain testMain = new TestMain();
        testMain.test();
    }
}
