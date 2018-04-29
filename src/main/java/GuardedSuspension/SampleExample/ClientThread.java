package GuardedSuspension.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/27.
 */
public class ClientThread extends Thread {
    private final Random random;

    private int num  = 0;

    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed){
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run(){
        for(int i = 0; i < 1000; i++){
            Request request = new Request("No." + i);
            num ++;
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try{
                Thread.sleep(random.nextInt(10000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
