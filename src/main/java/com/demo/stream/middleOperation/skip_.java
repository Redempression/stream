package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/** skip跳过流中的前n个元素，返回剩下的元素
 * @author 魏敏捷
 * @version 1.0
 */
public class skip_ {

    public static void main(String[] args) {
        testSkip();
        /**
         * 亚拉索::15
         * 易::14
         * */
    }

    /**	打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。*/
    private static void testSkip() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName() + "::" + author.getAge()));
    }
}
