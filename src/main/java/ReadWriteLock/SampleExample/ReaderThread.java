package ReadWriteLock.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/29.
 */
public class ReaderThread extends Thread{
    private final Data data;

    public ReaderThread(Data data){
        this.data = data;
    }

    public void run(){
        try{
            while(true){
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() +  " reads " + String.valueOf(readbuf));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
