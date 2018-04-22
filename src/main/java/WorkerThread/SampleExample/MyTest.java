package WorkerThread.SampleExample;
import org.junit.Test;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyTest {

    @Test
    public void test() {
        System.out.println("Test");
    }

    @Test
    public void testWorkerThread(){
        Channel channel = new Channel(5);
        channel.startWorkers();

        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }

    public static void main(String[] args){
        Channel channel = new Channel(5);
        channel.startWorkers();

        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }


}
