package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/**
 * map可以把对流中的元素进行计算或转换。
 * @author 魏敏捷
 * @version 1.0
 */
public class map_ {

    public static void main(String[] args) {
        testMap(); //蒙多,亚拉索,易

        testMap2(); //43,25,24

    }



    /** 利用map转换特点
     * 打印所有作家的姓名
     * */
    private static void testMap() {

        List<Author> authors = StreamDemo.getAuthors();

        //传统方式
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));


        //运用stream流里的map方法
        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(name -> System.out.println(name));
    }


    /** 利用map计算特点
     * 将所有作家的年龄+10并打印出来
     * */
    private static void testMap2() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .distinct()
                .forEach(newAge -> System.out.println(newAge));
    }

}
