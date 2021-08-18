package com.zkp.jwt.Test;

import com.zkp.jwt.pojo.User;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestException {
    /**
     * throws声明：如果一个方法内部的代码会抛出检查异常（checked exception），
     * 而方法自己又没有完全处理掉，则javac保证你必须在方法的签名上使用throws关键字声明这些可能抛出的异常，否则编译不通过。
     * @param args
     */
    public static void main(String[] args) throws Exception {
        int x = 0;
/**
 * try catch 可以通过catch捕获异常，如果捕获到可以进行操作，
 * 但是如果使用throw抛出异常必须在方法头或者类头使用throws声明将要抛出的异常
 *
 */
//        try {
//            int s = 0 / x;
//        } catch (Exception e) {
//            //e.printStackTrace();
//            throw new Exception("wodeyic");
//        }
//        throw new Exception("抛出异常后，后续语句会显示编译错误，无法执行");
//        System.out.println("xxxxxx");
        User user = new User(11,"zkp","dfa");
        User user1 = new User(1,"dfa","nihao");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        List<Integer> collect = list.stream().map(e -> e.getId()).collect(Collectors.toList());
        IntSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingInt(User::getId));
        Map<Integer, String> collect2 = list.stream().collect(Collectors.toMap(User::getId, User::getUsername));
        System.out.println(collect2);
        System.out.println(collect);
        System.out.println(collect1);
        try {
            foo();
        } catch (ArithmeticException ae) {
            System.out.println("处理异常");
           // ae.printStackTrace();
            throw new Exception("抛出了异常");
        }
        System.out.println("异常被捕获后会执行");
//        foo();
//        System.out.println("nihaho");
        String s= null;
        if( s == null)
            throw new IllegalArgumentException("User对象为空");

        System.out.println("前面有异常抛出，不会执行");
    }

    public static void foo()throws Exception{
        int a = 5/0;  //异常抛出点
        System.out.println("为什么还不给我涨工资!!!");  //////////////////////不会执行
    }
}
