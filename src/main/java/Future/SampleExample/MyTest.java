package Future.SampleExample;
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
        System.out.println("main beging");
        Host host = new Host();
        Data data_1 = host.request(10, 'A');
        Data data_2 = host.request(15, 'C');
        Data data_3 = host.request(5, 'B');

        System.out.println("main otherJob begin");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main otherJob end");

        System.out.println("data_1 = " + data_1.getContent());
        System.out.println("data_2 = " + data_2.getContent());
        System.out.println("data_3 = " + data_3.getContent());
    }

}
