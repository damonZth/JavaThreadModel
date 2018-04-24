package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 *
 */
public class FutureResult<T> extends Result<T> {
    private Result<T> result;
    private boolean ready = false;

    public synchronized void setResult(Result<T> result){
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    public synchronized T getResultValue(){
        while(!ready){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return result.getResultValue();
    }
}
