package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * ActiveObject的核心部分。
 *
 * SchedulerThread 包含一个队列ActivvationQueue，用于保存来自Proxy类的请求。
 * 当invoke方法被调用的时候，activationQueue中会增加一个请求；
 *
 * 同时，ScheduleThread实现了执行线程的run方法，run方法从队列中取出一个请求（takeRequest），然后执行（execute）该请求。
 *
 * 向队列中增加请求相当于对“主动对象”方法的“调用”。
 * 执行请求的execute方法相当于“主动对象”方法的“执行”
 *
 */
public class SchedulerThread extends Thread {
    private final ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    public void invoke(MethodRequest methodRequest) {
        activationQueue.putRequest(methodRequest);
    }

    public void run(){
        while(true){
            MethodRequest request = activationQueue.takeRequest();
            request.execute();
        }

    }


}
