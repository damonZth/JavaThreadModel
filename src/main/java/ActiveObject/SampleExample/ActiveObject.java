package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * 定义主动对象的接口
 *
 */
public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillcahr);

    public abstract void displayString(String str);
}
