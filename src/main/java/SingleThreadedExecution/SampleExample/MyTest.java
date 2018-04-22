package SingleThreadedExecution.SampleExample;
import SingleThreadedExecution.SampleExample.Example_1.GateNoSyn;
import SingleThreadedExecution.SampleExample.Example_1.GateSyn;
import SingleThreadedExecution.SampleExample.Example_1.UserThread;
import org.junit.Test;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyTest {

    @Test
    public void test01() {
        System.out.println("Test");
    }

    /**
     * Alice： Alaska
     * Bobby： Brazil
     * Chris： Canada
     */
    @Test
    public void test02(){
        System.out.println("Testing Gate, hit CTRL + C to exit");
        GateNoSyn gate = new GateNoSyn();
        new UserThread(gate, "Alice", "Alaska").start();//Alice 线程
        new UserThread(gate, "Bobby", "Brazil").start();//Bobby 线程
        new UserThread(gate, "Chris", "Canada").start();//Chris 线程
    }

    @Test
    public void test03(){
        System.out.println("Testing Gate, hit CTRL + C to exit");
        GateSyn gate = new GateSyn();
        //三个线程访问gate实例，此时就要考虑gate实例的线程安全性
        new UserThread(gate, "Alice", "Alaska").start();//Alice 线程
        new UserThread(gate, "Bobby", "Brazil").start();//Bobby 线程
        new UserThread(gate, "Chris", "Canada").start();//Chris 线程
    }

}
