package com.zkp.jwt.Test;

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

        try {
            foo();
        } catch (ArithmeticException ae) {
            System.out.println("处理异常");
           // ae.printStackTrace();
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
