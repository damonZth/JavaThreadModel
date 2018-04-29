package Balking.SampleExample;
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
        Data data = new Data("data.txt","(empty)");
        new ChangerThread("changerThread", data).start();
        new SaverThread("saverThread", data).start();

    }

}
