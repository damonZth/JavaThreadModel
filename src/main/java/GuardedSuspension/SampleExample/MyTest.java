package GuardedSuspension.SampleExample;
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
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice",3141591L).start();
        //new ClientThread(requestQueue, "Boby", 3232324L).start();
        new ServerThread(requestQueue, "Davi", 6543219L).start();
    }

}
