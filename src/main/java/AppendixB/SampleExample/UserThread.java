package AppendixB.SampleExample;

import org.omg.PortableServer.THREAD_POLICY_ID;
import sun.nio.cs.US_ASCII;

import java.util.Random;

/**
 * Created by Damon on 2018/4/27.
 */
public class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource){
        this.resource = resource;
    }

    public void run(){
        try{
            while (true){
                resource.use();
                Thread.sleep(random.nextInt(5000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        BoundedResource resource = new BoundedResource(4);

        for(int i = 0; i < 10; i++){
            new UserThread(resource).start();
        }
    }
}
