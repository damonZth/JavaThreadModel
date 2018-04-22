package AppendixB.SingleThreadedExecution;


import java.util.Date;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyStream_2 {
    //静态变量
    private static MyStream_2 instance = null;
    private Date date = new Date();

    private MyStream_2(){
        //空的构造器
    }

    public Date getDate(){
        return date;
    }

    public static MyStream_2 getInstance(){
        if(instance == null){
            synchronized (MyStream_2.class) {
                if(instance == null){
                    instance = new MyStream_2();
                }
            }
        }
        return instance;
    }
}
