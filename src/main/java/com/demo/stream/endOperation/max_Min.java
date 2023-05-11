package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

/**
 * max&min 可以用来或者流中的最值。
 *
 * @author 魏敏捷
 * @version 1.0
 */
public class max_Min {

    public static void main(String[] args) {

        testMax(); //100
        testMin(); //56

        testMax2();

        test28();

    }

    /**
     * 获取所出书籍的最低分并打印。
     */
    private static void testMin() {

        List<Author> authors = StreamDemo.getAuthors();

        //Stream<Author>  -> Stream<Book> ->Stream<Integer>  ->求值
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        System.out.println(min.get());
    }

    /**
     * 获取所出书籍的最高分并打印。
     */
    private static void testMax() {

        List<Author> authors = StreamDemo.getAuthors();

        //Stream<Author>  -> Stream<Book> ->Stream<Integer>  ->求值
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        System.out.println(max.get());
    }

    /**
     * 不用max,min来解决
     */
    private static void testMax2() {

        List<Author> authors = StreamDemo.getAuthors();

        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
//                .sorted((o1,o2) -> o1 - o2)  //最低分
                .sorted((o1, o2) -> o2 - o1) //最高分
                .limit(1)
                .forEach(score -> System.out.println(score));

    }

    private static void test28() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream
                //parallel方法可以把串行流转换成并行流。
                .parallel()
                //peek()是专门用来调试的方法，属于中间操作，相当于中间操作版的forEach()
                //这里是输出数据和当前的线程名称
                .peek(num -> System.out.println(num + Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                .get();
        System.out.println(sum);
    }

}
