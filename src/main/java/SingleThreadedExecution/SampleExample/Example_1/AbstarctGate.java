package SingleThreadedExecution.SampleExample.Example_1;

/**
 * Created by Damon on 2018/4/22.
 */
public abstract class AbstarctGate {
    private int counter;//用于记录通过Gate人数
    private String name;
    private String address;

    abstract void pass(String name, String address);

    abstract void check();

    abstract String toStr();
}
