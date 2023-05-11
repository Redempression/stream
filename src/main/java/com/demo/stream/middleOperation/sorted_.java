package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/** sorted可以对流中的元素进行排序。
 * @author 魏敏捷
 * @version 1.0
 */
public class sorted_ {

    public static void main(String[] args) {

        testSorted();
        /**
         * 蒙多::33
         * 亚拉索::15
         * 易::14
         * */
    }


    /**
     * 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。输出排序后的作家姓名和年龄
     * */
    private static void testSorted() {

        List<Author> authors = StreamDemo.getAuthors();

        //通过空参的sorted()方法实现
        authors.stream()
                .distinct()
                .sorted()
                .forEach(author -> System.out.println(author.getName() + "::" + author.getAge()));

        //通过有参的sorted()方法实现
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(author -> System.out.println(author.getName() + "::" + author.getAge()));
    }
}
