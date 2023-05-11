package com.demo.stream.middleOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/** limit可以设置流的最大长度，超出的部分将被抛弃。
 * @author 魏敏捷
 * @version 1.0
 */
public class limit_ {

    public static void main(String[] args) {

        testLimit(); //蒙多,亚拉索

    }

    /**对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,
     * 然后打印其中年龄最大的两个作家的姓名。*/
    private static void testLimit() {
        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }
}
