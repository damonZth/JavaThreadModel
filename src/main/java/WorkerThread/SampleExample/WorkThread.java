package WorkerThread.SampleExample;

/**
 * Created by Damon on 2018/4/22.
 */
public class WorkThread extends Thread {
    private final Channel channel;

    public WorkThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run(){
        while (true){
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
