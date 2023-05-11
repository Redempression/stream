package com.demo.stream.optional;

import com.demo.stream.pojo.Author;

import java.util.Optional;
import java.util.function.Consumer;


/**
 * @author 魏敏捷
 * @version 1.0
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Author author = getAuthor();

        //System.out.println(author.getName());
        //NullPointerException
        /**
         * 我们在编写代码的时候出现最多的就是空指针异常。所以在很多情况下我们需要做各种非空的判断。
         * 尤其是对象中的属性还是一个对象的情况下。这种判断会更多。
         * 而过多的判断语句会让我们的代码显得臃肿不堪。
         * 所以在JDK8中引入了Optional,养成使用Optional的习惯后你可以写出更优雅的代码来避免空指针异常。
         * 并且在很多函数式编程相关的API中也都用到了Optional，如果不会使用Optional也会对函数式编程的学习造成影响。
         *
         * */


        /**我们一般使用**Optional**的**静态方法ofNullable**来把数据封装成一个Optional对象。
         * 无论传入的参数是否为null都不会出现问题。
         * */
        Optional<Author> author1 = Optional.ofNullable(author);
        //ifPresent 表示如果存在的话
        author1.ifPresent(result -> System.out.println(result.getName()));
        //由于是null，所以默认这里的输出是不会被执行到的

        /**
         * 你可能会觉得还要加一行代码来封装数据比较麻烦。但是如果改造下getAuthor方法，
         * 让其的返回值就是封装好的Optional的话，我们在使用时就会方便很多。如下：
         * */
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(new Consumer<Author>() {
            @Override
            public void accept(Author author2) {
                System.out.println(author2.getName());
            }
        });



        /**如果你确定一个对象不是空的则可以使用Optional的静态方法of来把数据封装成Optional对象。
         * 但是一定要注意，如果使用of的时候传入的参数必须不为null。
         * */
        Optional<Author> authorOptional2 = Optional.of(author);


        /**
         * 如果一个方法的返回值类型是Optional类型。而如果我们经判断发现某次计算得到的返回值为null，
         * 这个时候就需要把null封装成Optional对象返回。这时则可以使用Optional的静态方法empty来进行封装。
         * */


    }

    public static Optional<Author> getAuthorOptional(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);

        return Optional.ofNullable(author);
    }

    public static Author getAuthor(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        //手动设置为null，模拟空指针异常
        return null;
    }
}
