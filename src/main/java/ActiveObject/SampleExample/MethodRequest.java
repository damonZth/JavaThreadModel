package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 * 抽象类
 */
abstract class MethodRequest<T> {
    protected final Servant servant;
    protected final FutureResult<T> futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult){
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
