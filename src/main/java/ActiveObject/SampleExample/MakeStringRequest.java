package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * MakeStringRequest “生成字符串”的类
 *
 * MakeStringRequest与ActiveObject接口的makeString方法相对应。同时，MakeStringRequest的实例由Proxy的makeString方法创建。
 *
 * execute方法调用Servant的makeString方法。与“执行”请求相对应调用futureResul的setResult方法“设置请求的返回值”
 *
 * makeString方法的参数与MakeStringRequest的实例字对应
 * makeString方法的调用与MakeStringRequest的实例的创建和SchedulerThread的invoke方法的调用对应
 * makeString方法的执行与servant的makeString方法的调用对应
 * makeString方法的返回值与通过setResult向futureResult设置result对应
 *
 */
public class MakeStringRequest  extends MethodRequest<String>{
    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, FutureResult<String> futureResult, int count, char fillcahr) {
        super(servant, futureResult);
        this.count = count;
        this.fillchar = fillcahr;
    }

    public void execute() {
        Result<String> result = servant.makeString(count, fillchar);
        futureResult.setResult(result);
    }
}
