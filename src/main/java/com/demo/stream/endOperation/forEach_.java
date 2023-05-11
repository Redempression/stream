package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;

/** forEach
 *  对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。
 * @author 魏敏捷
 * @version 1.0
 */
public class forEach_ {

    public static void main(String[] args) {
        testForEach();
        /**
         * 蒙多
         * 亚拉索
         * 易
         * */
    }

    /**输出所有作家的名字*/
    private static void testForEach() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(name -> System.out.println(name));
    }


}
