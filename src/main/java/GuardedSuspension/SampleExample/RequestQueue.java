package GuardedSuspension.SampleExample;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Damon on 2018/4/27.
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }

    public synchronized Request getRequest(){
        while(queue.peek() == null){
            try {
                wait();//执行wait，等待条件放生改变
                //wait的线程如果不被notify/notifyall方法唤醒，便会一直在等待队列中。
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public boolean isNull(){
        return queue.peek() == null;
    }
}
