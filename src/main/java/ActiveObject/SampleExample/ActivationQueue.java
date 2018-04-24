package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * putRequest方法，将请求添加到队列
 * takeRequest方法，从队列中取出请求
 */
public class ActivationQueue {
    private static final int MAX_METHOD_REQUEST = 100;
    private final MethodRequest[] requestQueue;

    private int tail;//下次putRequest的位置
    private int head;//下次takeRequest的位置
    private int count;//methodRequest的数量

    public ActivationQueue(){
        this.requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    public synchronized void putRequest(MethodRequest methodRequest) {
        while(count >= requestQueue.length){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        requestQueue[tail] = methodRequest;
        tail = (tail + 1) % requestQueue.length;
        count ++;
        notifyAll();
    }

    public synchronized MethodRequest takeRequest() {
        while (count <= 0){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count --;
        notifyAll();
        return methodRequest;
    }
}
