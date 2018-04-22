package AppendixB.SingleThreadedExecution;

import java.util.Date;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyStream_3 {

    private static class Holder{
        public static MyStream_3 instance = new MyStream_3();
    }

    private Date date = new Date();
    private MyStream_3(){
        //空构造器
    }

    public Date getDate(){
        return date;
    }

    public static MyStream_3 getInstance(){
        return Holder.instance;
    }
}
