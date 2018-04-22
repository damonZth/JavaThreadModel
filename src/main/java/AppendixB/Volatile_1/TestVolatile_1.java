package AppendixB.Volatile_1;

/**
 * Created by Damon on 2018/4/22.
 */
public class TestVolatile_1 {

    public static void main(String[] args){
        Runner runner = new Runner();

        /*
         * 主函数 首先实例化一个线程类Runner。
         * 1、调用start方法启动runner线程
         * 2、调用shutDown方法将quit设置为true，以终止runner线程。
         *
         * 结果：在调用shutDown方法后，可能并不会立即终止runner线程。
         * 原因：向字段quit写值的线程是主函数线程，而读取quit值的线程是Runner线程。
         *       它们是不同的线程，主函数的线程对quit值的改变可能对Runner线程永远不可见。
         * 改进：将quit字段使用关键字volatile修饰，保证其原子性
         */
        //启动线程
        runner.start();

        //终止线程
        runner.shutDown();
    }
}

class Runner extends Thread{
    private boolean quit = false;

    public void run(){
        //run()方法在quit变为true之前会一直进行while循环。当quit变为true时，while循环结束，显示字符串Over！
        while(!quit){
            System.out.println("***");
        }
        System.out.println("Over！");
    }

    public void shutDown(){
        //将字段quit设置为true
        quit = true;
    }
}

class RunnerV extends Thread{
    private volatile boolean quit = false;

    public void run(){
        //run()方法在quit变为true之前会一直进行while循环。当quit变为true时，while循环结束，显示字符串Over！
        while(!quit){
            System.out.println("***");
        }
        System.out.println("Over！");
    }

    public void shutDown(){
        //将字段quit设置为true
        quit = true;
    }
}

