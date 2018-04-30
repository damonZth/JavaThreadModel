package ThreadSpecificStorage.SampleExample;
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
        new ClientThread("Alice").start();
        new ClientThread("Davie").start();
        new ClientThread("Bobi").start();
    }

}
