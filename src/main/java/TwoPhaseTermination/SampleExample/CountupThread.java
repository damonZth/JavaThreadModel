package TwoPhaseTermination.SampleExample;

/**
 * Created by Damon on 2018/4/23.
 */
public class CountupThread extends Thread {
    //计数器
    private long counter = 0;

    //发出终止请求后将shutdownRequeed 变为true
    private volatile boolean shutdownRequested = false;

    //终止请求
    public void shutdownRequest(){
        shutdownRequested = true;
        interrupt();
    }

    //检查是否发出了终止请求
    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    //线程体
    public final void run(){
        try{
            while (!isShutdownRequested()){//检查是否接收到终止请求
                doWork();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            doShutDown();
        }
    }

    //操作
    private void doWork() throws InterruptedException{
        counter ++;
        System.out.println("doWork: counter + " + counter);
        Thread.sleep(500);
    }

    //终止处理
    private void doShutDown(){
        System.out.println("doShutDown: counter = " + counter);
    }

}
