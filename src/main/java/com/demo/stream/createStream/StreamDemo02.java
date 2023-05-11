package com.demo.stream.createStream;

import com.demo.stream.pojo.Author;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 魏敏捷dddddd
 * @version 1.0
 */
public class StreamDemo02 {

    public static void main(String[] args) {
        test01(); //蒙多,亚拉索,易

        test02(); //3,4,5

        test03(); //蜡笔小新---19  蜡笔小新
    }

    /**
     * 单列集合： `集合对象.stream()`
     */
    private static void test01() {
        List<Author> authors = StreamDemo.getAuthors();
        Stream<Author> stream = authors.stream();
        stream.distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    /**
     * 数组：`Arrays.stream(数组) `或者使用`Stream.of`来创建
     */
    private static void test02() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(arr);
        //Stream<Integer> stream = Stream.of(arr);
        stream.filter(integer -> integer >= 3)
                .forEach(integer -> System.out.println(integer));
    }


    /**
     * 双列集合：转换成单列集合后再创建
     */
    private static void test03() {

        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 19);
        map.put("黑子", 17);
        map.put("日向翔阳", 16);

        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();

        //1、用entrySet()
        stream.filter(entry -> entry.getValue() > 18)
                .forEach(entry -> System.out.println(entry.getKey() + "---" + entry.getValue()));

        //2、用keySet()
        map.keySet()
                .stream()
                .filter(entry -> entry.equals("蜡笔小新"))
                .forEach(entry -> System.out.println(entry));
    }

}
