package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/**
 * distinct可以去除流中的重复元素。
 * 注意：distinct方法是依赖Object的equals方法来判断是否是相同对象的，Object的equals实际上是==的比较，
 * 也就是如果两个地址相同才算是同一个对象。
 * 实际生产时不仅仅需要地址相同，还要具体内容相同，所以这时根据需要来重写equals方法。
 * @author 魏敏捷
 * @version 1.0
 */
public class distinct_ {

    public static void main(String[] args) {
        testDistinct(); //蒙多,亚拉索,易
    }


    /**打印所有作家的姓名，并且要求其中不能有重复元素。*/
    private static void testDistinct() {

        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }
}


