package GuardedSuspension.SampleExample;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

/**
 * Created by Damon on 2018/4/27.
 */
public class ServerThread extends Thread {
    private final Random random;

    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run(){
        for(int i = 0; i < 1000; i++){
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(random.nextInt(10));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
