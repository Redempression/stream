package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.Arrays;
import java.util.List;

/** flatMap
 * map只能把一个对象转换成另一个对象来作为流中的元素。
 * 而flatMap可以把一个对象转换成多个对象作为流中的元素。
 * @author 魏敏捷
 * @version 1.0
 */
public class flatMap_ {

    public static void main(String[] args) {

        testFlatMap();
        /**
         * 刀的两侧是光明与黑暗
         * 一个人不能死在同一把刀下
         * 那风吹不到的地方
         * 吹或不吹
         * 你的剑就是我的剑
         * 风与剑
         * */

        testFlatMap2();
        /**
         * 哲学
         * 爱情
         * 个人成长
         * 个人传记
         * */
    }

    /**打印所有书籍的名字。要求对重复的元素进行去重。*/
    private static void testFlatMap() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));


    }

    /**打印现有书籍数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情*/
    private static void testFlatMap2() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                //由于书籍里的分类有可能一个书籍有几种分类，所以用flatMap，然后用数组里的split分割符将,左右分割
                //这样就不会出现”哲学,爱情”这种格式
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }
}
