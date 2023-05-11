package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.Arrays;
import java.util.List;

/** count 可以用来获取当前流中元素的个数。
 * @author 魏敏捷aaa
 * @version 1.0
 */
public class count_ {

    public static void main(String[] args) {
        testCount(); // 6

    }

    /**打印这些作家的所出书籍的数目，注意删除重复元素。*/
    private static void testCount() {

        List<Author> authors = StreamDemo.getAuthors();

        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .distinct()
                .count();
        System.out.println(count);
    }


}
