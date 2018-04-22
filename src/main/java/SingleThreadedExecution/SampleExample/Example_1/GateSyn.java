package SingleThreadedExecution.SampleExample.Example_1;

/**
 * Created by Damon on 2018/4/22.
 * 线程安全的Gate
 *
 * 使用synchronized关键字修饰的方法，能够确保该方法同时只能由一个线程执行。
 * synchronized方法只允许一个线程同时执行。如果某个线程正在执行synchronized方法，其他线程则无法进入该方法。
 * 即，从多线程的角度来看，synchronized方法执行的操作是“不可分割的操作”----原子操作。
 */
public class GateSyn extends AbstarctGate{
    private int counter = 0;//用于记录通过Gate人数
    private String name = "Nobody";
    private String address = "NoWhere";

    public synchronized void pass(String name, String address){ //原子操作
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("*********** BROKEN  ***********" + this.toStr());
        }else{
            System.out.println("*********** OK  ***********" + this.toStr());
        }
    }

    public synchronized String toStr(){
        return "No." + counter + " : "+ name + "-->" + address;
    }

}
