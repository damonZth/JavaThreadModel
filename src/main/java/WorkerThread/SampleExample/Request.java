package WorkerThread.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/22.
 * 表示工作请求
 */
public class Request {
    private final String name;//委托者
    private final int number;//工作编号
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name  = name;
        this.number = number;
    }

    //执行工作的方法
    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try{
            Thread.sleep(random.nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        return "[ Request from " + name + " No." + number + "]";
    }
}
