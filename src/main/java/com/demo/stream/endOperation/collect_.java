package com.demo.stream.endOperation;

import com.demo.stream.createStream.StreamDemo;
import com.demo.stream.pojo.Author;
import com.demo.stream.pojo.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/** collect 把当前流转换成一个集合。
 * @author 魏敏捷aaa
 * @version 1.0
 */
public class collect_ {

    public static void main(String[] args) {
        testCollectToList(); //[蒙多, 亚拉索, 易]

        testCollectToSet();
        //[那风吹不到的地方, 你的剑就是我的剑, 刀的两侧是光明与黑暗, 风与剑, 吹或不吹, 一个人不能死在同一把刀下]

        testCollectToMap();
        /**
         * 亚拉索::[Book(id=3, name=那风吹不到的地方, category=哲学, score=85, intro=带你用思维去领略世界的尽头), Book(id=3, name=那风吹不到的地方, category=哲学, score=85, intro=带你用思维去领略世界的尽头), Book(id=4, name=吹或不吹, category=爱情,个人传记, score=56, intro=一个哲学家的恋爱观注定很难把他所在的时代理解)]
         * 蒙多::[Book(id=1, name=刀的两侧是光明与黑暗, category=哲学,爱情, score=88, intro=用一把刀划分了爱恨), Book(id=2, name=一个人不能死在同一把刀下, category=个人成长,爱情, score=99, intro=讲述如何从失败中明悟真理)]
         * 易::[Book(id=5, name=你的剑就是我的剑, category=爱情, score=56, intro=无法想象一个武者能对他的伴侣这么的宽容), Book(id=6, name=风与剑, category=个人传记, score=100, intro=两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？), Book(id=6, name=风与剑, category=个人传记, score=100, intro=两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？)]
         * */

        testCollectToMap2();
        /**
         * 亚拉索--85
         * 蒙多--99
         * 易--100
         * */
    }


    /**获取一个存放所有作者名字的List集合。*/
    private static void testCollectToList() {

        List<Author> authors = StreamDemo.getAuthors();

        List<String> list = authors.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**获取一个所有书名的Set集合。*/
    private static void testCollectToSet() {

        List<Author> authors = StreamDemo.getAuthors();

        //这里不需要distinct()去重，因为Set集合的特点就是存放不重复的数据
        Set<String> set = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .collect(Collectors.toSet());
        System.out.println(set);

    }

    /**获取一个Map集合，map的key为作者名，value为List<Book>*/
    private static void testCollectToMap() {

        List<Author> authors = StreamDemo.getAuthors();

        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        //使用map的增强for循环遍历
        for (String name : map.keySet()) {
            System.out.println(name + "::" + map.get(name));
        }
    }


    /**获取一个Map集合，map的key为作者名，value为该作者的作品的最高分Integer*/
    private static void testCollectToMap2() {

        List<Author> authors = StreamDemo.getAuthors();

        Map<String, Integer> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(),
                        author -> author.getBooks().stream()
                                .map(book -> book.getScore())
                                .max(((o1, o2) -> o1 - o2))
                                //使用orElseGet安全获取值
                                .orElseGet(() -> 0)
                ));

        //使用map的增强for循环遍历
        for (String s : map.keySet()) {
            System.out.println(s + "--" + map.get(s));
        }
    }
}
