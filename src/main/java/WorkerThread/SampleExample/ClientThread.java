package WorkerThread.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/22.
 * 发送工作请求
 */
public class ClientThread extends Thread{

    private final Channel channel;
    private static final Random random = new Random();

    //客户端线程构造器
    public ClientThread(String name, Channel channel){
        super(name);//客户端线程名
        this.channel = channel;
    }

    public void run(){
        try{
            for(int i = 0; true; i++){
                //客户点线程产出工作请求
                Request request = new Request(getName(), i);
                //将工作请求放入到工作队列中
                channel.putRequest(request);
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
