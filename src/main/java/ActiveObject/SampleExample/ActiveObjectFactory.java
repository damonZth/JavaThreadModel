package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * 用来构成ActiveObject对象的类。
 *
 * createActiveObject的静态方法，创建ActiveObject对象
 *
 * ActiveObject对象由以下四个类实例组合而出：
 * Servant：执行实际处理的类-----实现了ActiveObject接口
 * ActivationQueue：按顺序保存MethodRequest对象的类
 * SchedulerThread：调用execute方法处理MethodRequest对象的类
 * Proxy：将方法的调用转换为MethodRequest对象的类-----实现了ActiveObject接口
 *
 */
public class ActiveObjectFactory {

    public static ActiveObject createActiveObject(){
        Servant servant = new Servant();
        ActivationQueue activationQueue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(activationQueue);
        Proxy proxy = new Proxy(schedulerThread, servant);
        schedulerThread.start();//
        return proxy;
    }
}
