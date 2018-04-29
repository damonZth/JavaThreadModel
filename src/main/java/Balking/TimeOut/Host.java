package Balking.TimeOut;

import Balking.SampleExample.SaverThread;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeoutException;

/**
 * Created by Damon on 2018/4/29.
 */
public class Host {
    private final long timeout;//超时时间
    private boolean ready = false;//方法正常执行时为true

    public Host(long timeout){
        this.timeout = timeout;
    }

    //修改时间
    public synchronized void setExecutable(boolean on){
        ready = on;
        notifyAll();
    }

    public synchronized void execute()throws InterruptedException, TimeoutException{
        long start = System.currentTimeMillis();//开始时间
        while(!ready){
            long now = System.currentTimeMillis();//当前时间
            long rest = timeout - (now - start);//剩余时间
            if(rest <= 0){
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    //实际处理操作
    private void doExecute(){
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }

    public static void main(String[] args){
        Host host = new Host(1000);
        try{
            System.out.println("execute begin");
            host.execute();
        }catch (TimeoutException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
