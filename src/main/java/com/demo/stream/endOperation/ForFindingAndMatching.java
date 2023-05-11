package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/** 用于查找和匹配的终结操作
 * @author 魏敏捷
 * @version 1.0
 */
public class ForFindingAndMatching {

    public static void main(String[] args) {


        testAnyMatch(); //true
        testAllMatch(); //false
        testNoneMatch(); //true
        for (int i = 0; i < 100; i++) {
             testFindAny(); //蒙多 ,  亚拉索
        }

//        testFindFirst(); //易
    }

    /**anyMatch 可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。*/
    private static void testAnyMatch() {

        /**判断是否有年龄在29以上的作家*/
        List<Author> authors = StreamDemo.getAuthors();

        boolean match = authors.stream()
                .map(author -> author.getAge())
                .anyMatch(age -> age > 29);

        System.out.println(match);


    }
    /**allMatch 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。*/
    private static void testAllMatch() {

        /**判断是否所有的作家都是成年人*/
        List<Author> authors = StreamDemo.getAuthors();

        boolean match = authors.stream()
                .map(author -> author.getAge())
                .allMatch(age -> age >= 18);

        System.out.println(match);



    }

    /**noneMatch 可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false*/
    private static void testNoneMatch() {

        /**判断作家是否都没有超过100岁的。*/
        List<Author> authors = StreamDemo.getAuthors();

        boolean match = authors.stream()
                .map(author -> author.getAge())
                .noneMatch(age -> age > 100);

        System.out.println(match);



    }

    /**findAny 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
     * 注意：此执行在一般情况下，并不会随机输出，而是按顺序输出，因为该流是有顺序的串行流，按照最优执行会按照顺序，
     * 如果我们想要看到随机选择，需要改成并行流,即在findAny()前加上parallel()。
     * 详见 https://blog.csdn.net/qq_31635851/article/details/111178278
     * */
    private static void testFindAny() {

        /**获取任意一个年龄小于18的作家，如果存在就输出他的名字*/
        List<Author> authors = StreamDemo.getAuthors();

        Optional<String> name = authors.stream()
                .filter(author -> author.getAge() < 18)
                .map(author -> author.getName())
                .parallel()
                .findAny();

        name.ifPresent(authorName -> System.out.println(authorName));

    }

    /**findFirst 获取流中的第一个元素。*/
    private static void testFindFirst() {

        /**获取一个年龄最小的作家，并输出他的姓名。*/
        List<Author> authors = StreamDemo.getAuthors();

        Optional<String> name = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .distinct()
                .map(author -> author.getName())
                .findFirst();

        name.ifPresent(authorName -> System.out.println(authorName));
    }


}
