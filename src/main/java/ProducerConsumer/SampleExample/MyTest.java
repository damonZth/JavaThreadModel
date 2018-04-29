package ProducerConsumer.SampleExample;
import GuardedSuspension.A3.TalkThread;
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
        Table table = new Table(3);
        new MakerThread("Alice", table, 31415).start();
        new MakerThread("Boby", table, 33333).start();
        new MakerThread("Davie", table, 533234).start();

        new EaterThread("Tony", table, 43234).start();
        new EaterThread("Rucy", table, 8923).start();

    }

}
