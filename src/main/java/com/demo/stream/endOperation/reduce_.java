package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;

import java.util.List;
import java.util.Optional;


/**
 * reduce归并 对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
 *
 * @author 魏敏捷
 * @version 1.0
 */
public class reduce_ {

    public static void main(String[] args) {


        /**reduce两个参数的重载形式内部的计算方式如下：
         *  T result = identity;
         *  for (T element : this stream){
         *       result = accumulator.apply(result, element)
         *  }
         *  return result;
         *  案例为test01，test02，test03
         */

        test01(); //年龄的和为62
        test02(); //所有作者中年龄的最大值33
        test03(); //所有作者中年龄的最小值14


        /**reduce一个参数的重载形式内部的计算
         *  boolean foundAny = false;
         *      T result = null;
         * 	//代码大致意思就是将第一个值作为初始化值，然后再拿后面的元素和这个变量进行相应的计算
         *      for (T element : this stream) {
         *          if (!foundAny) {
         *              foundAny = true;
         *              result = element;
         *          }
         *          else
         *              result = accumulator.apply(result, element);
         *      }
         *      return foundAny ? Optional.of(result) : Optional.empty();
         *
         *      案例为test04，test05
         */

        test04(); //所有作者中年龄的最大值33
        test05(); //所有作者中年龄的最小值14



    }

    /**
     * 使用reduce一个参数的重载形式求所有作者中年龄的最小值
     */
    private static void test05() {

        List<Author> authors = StreamDemo.getAuthors();

        Optional<Integer> optionalReduce = authors.stream()
                .map(author -> author.getAge())
                .distinct()
                //因为是求最小值，所以这里初始化值应该要是这些比较的数里最大的，Integer.MAX_VALUE表示Integer里最大的
                //后面通过比较后通过三元运算符来得到最小值
                .reduce((integer, integer2) -> integer < integer2 ? integer : integer2);

        optionalReduce.ifPresent(age -> System.out.println("所有作者中年龄的最小值" +age));

    }

    /**
     * 使用reduce一个参数的重载形式求所有作者中年龄的最大值
     */
    private static void test04() {
        List<Author> authors = StreamDemo.getAuthors();

        Optional<Integer> optionalReduce = authors.stream()
                .map(author -> author.getAge())
                .distinct()
                //因为是求最大值，所以这里初始化值应该要是这些比较的数里最小的，写0可以，Integer.MIN_VALUE表示Integer里最小的也可以
                //后面通过比较后通过三元运算符来得到最大值
                .reduce((integer, integer2) -> integer > integer2 ? integer : integer2);

        optionalReduce.ifPresent(age -> System.out.println("所有作者中年龄的最大值" +age));


    }

    /**
     * 使用reduce两个参数的重载形式求所有作者中年龄的最小值
     */
    private static void test03() {

        List<Author> authors = StreamDemo.getAuthors();

        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .distinct()
                //因为是求最小值，所以这里初始化值应该要是这些比较的数里最大的，Integer.MAX_VALUE表示Integer里最大的
                //后面通过比较后通过三元运算符来得到最小值
                .reduce(Integer.MAX_VALUE, (integer, integer2) -> integer < integer2 ? integer : integer2);

        System.out.println("所有作者中年龄的最小值" + reduce);
    }

    /**
     * 使用reduce两个参数的重载形式求所有作者中年龄的最大值
     */
    private static void test02() {

        List<Author> authors = StreamDemo.getAuthors();

        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .distinct()
                //因为是求最大值，所以这里初始化值应该要是这些比较的数里最小的，写0可以，Integer.MIN_VALUE表示Integer里最小的也可以
                //后面通过比较后通过三元运算符来得到最大值
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer > integer2 ? integer : integer2);

        System.out.println("所有作者中年龄的最大值" + reduce);
    }

    /**
     * 使用reduce两个参数的重载形式求所有作者年龄的和
     */
    private static void test01() {

        List<Author> authors = StreamDemo.getAuthors();

        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (integer, integer2) -> integer + integer2);

        System.out.println("年龄的和为" + reduce);

    }


}
