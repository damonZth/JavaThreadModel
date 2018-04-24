package TwoPhaseTermination.SampleExample;
import org.junit.Test;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyTest {

    @Test
    public void test() {
        System.out.println("Test");
    }

    public static void main(String[] args){
        System.out.println("main : begin");
        try{
            //启动线程
            CountupThread countupThread = new CountupThread();
            countupThread.start();

            //停留一段时间
            Thread.sleep(10000);

            //发出终止请求
            System.out.println("main : shutDownRequest");
            countupThread.shutdownRequest();

            System.out.println("main : join");

            //等待线程终止
            countupThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("main : end");
    }

}
