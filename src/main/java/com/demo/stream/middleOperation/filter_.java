package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/**
 * filter可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中。
 * @author 魏敏捷
 * @version 1.0
 */
public class filter_ {

    public static void main(String[] args) {
        testFilter();  //蒙多,亚拉索


    }

    /**打印所有姓名长度大于1的作家的姓名*/
    private static void testFilter() {
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));
    }


}
