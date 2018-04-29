package AppendixB.SampleExample;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Damon on 2018/4/27.
 */
public class BoundedResource {
    private final Semaphore semaphore;//计数信号量
    private final int permits;//允许的线程数
    private final static Random random = new Random(314159);

    public BoundedResource(int permits){
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    //使用资源
    public void use() throws InterruptedException{
        semaphore.acquire();//确保存在可用资源
        try{
            doUse();
        }finally {
            semaphore.release();//释放资源
        }
    }

    //实际使用
    protected void doUse() throws InterruptedException{
        Log.println("Begin: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End: used = " + (permits - semaphore.availablePermits()));
    }
}


class Log{
    public static void println(String string){
        System.out.println(Thread.currentThread().getName() + ": " + string);
    }
}
