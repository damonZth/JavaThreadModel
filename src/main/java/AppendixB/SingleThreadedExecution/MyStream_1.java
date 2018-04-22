package AppendixB.SingleThreadedExecution;


import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.Date;

/**
 * Created by Damon on 2018/4/22.
 * 单例模式的实现方式一
 */

public class MyStream_1 {
    //静态变量
    private static MyStream_1 instance = null;
    private Date date = new Date();

    private MyStream_1(){
        //空的构造函数
    }

    public Date getDate(){
        return date;
    }

    //使用静态方法来获取类的实例。
    public static synchronized MyStream_1 getInstance(){
        if(instance == null){
            instance = new MyStream_1();
        }
        return instance;
    }
}
