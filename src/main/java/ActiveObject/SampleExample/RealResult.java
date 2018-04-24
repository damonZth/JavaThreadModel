package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 */
public class RealResult<T> extends Result<T> {
    private final T resultValue;

    public RealResult(T resultValue){
        this.resultValue = resultValue;
    }

    public T getResultValue() {
        return resultValue;
    }
}
