package WorkerThread.SampleExample;

/**
 * Created by Damon on 2018/4/22.
 */
public class Channel {
    private static final int MAX_REQUEST = 100;//最大存放工作量
    private final Request[] requestQueue;//请求队列
    private int tail;//下次取request的位置
    private int head;//下次存request的位置
    private int count;//request个数

    private final WorkThread[] workers;//工人队列

    //构造器
    public Channel(int threads){
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        //添加工人
        workers = new WorkThread[threads];
        for(int i = 0; i < workers.length; i++){
            workers[i] = new WorkThread("Worker-" + i, this);
        }
    }

    //工人工作
    public void startWorkers(){
        for(int i = 0; i < workers.length; i++){
            workers[i].start();
        }
    }

    //放入工作请求
    public synchronized void putRequest(Request request) {
        while(count >= requestQueue.length){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        requestQueue[tail]  = request;
        tail = (tail + 1) % requestQueue.length; //添加一个工作后，tail指针后移一位
        count ++;
        notifyAll();
    }

    //取工作请求
    public synchronized Request takeRequest(){
        while(count <= 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count --;
        notifyAll();
        return request;
    }

}
