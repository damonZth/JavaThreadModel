package GuardedSuspension.A3;

import GuardedSuspension.SampleExample.Request;
import GuardedSuspension.SampleExample.RequestQueue;

/**
 * Created by Damon on 2018/4/28.
 */
public class MyTest {

    public static void main(String[] args){
        RequestQueue input = new RequestQueue();
        RequestQueue output = new RequestQueue();
        input.putRequest(new Request("hello"));
        new TalkThread(input, output, "Alice").start();
        new TalkThread(output,input, "Davie").start();
    }
}
