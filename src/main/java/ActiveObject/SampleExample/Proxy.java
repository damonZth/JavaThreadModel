package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * 被MakerClientThread类和DisplayClientThead类调用，将方法的调用转换为对象
 *
 * makeString方法，利用接收到的参数，创建一个MakeStringRequest的实例，然后将该实例传递给Scheduler的invoke方法。
 *
 * displayString方法，创建一个DispalyStringRequest实例，然后将该实例传递个Scheduler的invoke方法。
 */
 class Proxy implements ActiveObject{
    private final SchedulerThread schedulerThread;
    private final Servant servant;

    public Proxy(SchedulerThread schedulerThread, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    public Result<String> makeString(int count, char fillcahr) {
        FutureResult<String>  futureResult = new FutureResult<String>();
        schedulerThread.invoke(new MakeStringRequest(servant, futureResult, count, fillcahr));
        return futureResult;
    }

    public void displayString(String str) {
        schedulerThread.invoke(new DisplayStringRequest(servant, str));

    }
}
