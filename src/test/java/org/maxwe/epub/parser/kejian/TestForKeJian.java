package org.maxwe.epub.parser.kejian;

import org.maxwe.epub.parser.sample.BookTest;
import org.maxwe.epub.parser.core.INavigation;
import org.maxwe.epub.parser.impl.Book;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2015-11-10 16:19.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TestForKeJian {
    private static String path = BookTest.class.getResource("/").getPath() + "kejian";
    public static void main(String[] args) throws Exception{
        Book book = new Book(path);
        LinkedList<INavigation> navigation = book.getContent().getNavigation();
        System.out.println(navigation.size());
    }
}
