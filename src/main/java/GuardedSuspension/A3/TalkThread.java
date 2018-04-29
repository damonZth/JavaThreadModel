package GuardedSuspension.A3;

import GuardedSuspension.SampleExample.Request;
import GuardedSuspension.SampleExample.RequestQueue;

/**
 * Created by Damon on 2018/4/28.
 */
public class TalkThread extends Thread{
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name){
        super(name);
        this.input = input;
        this.output = output;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " :Begin");
        for(int i = 0; i < 20; i++){
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }

        System.out.println(Thread.currentThread().getName() + " :end");
    }
}
