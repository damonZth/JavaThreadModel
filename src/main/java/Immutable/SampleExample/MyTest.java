package Immutable.SampleExample;
import org.junit.Test;

/**
 * Created by Damon on 2018/4/22.
 */
public class MyTest {

    static final int i;
    //final静态字段赋值的方式，要么在声明的时候直接复制，
    // 要么在静态代码块内对静态代码块中对final静态字段赋值。
    static{
        i = 0;
    }



    public int add(final int a, final int b){
        System.out.println(a);
        System.out.println(b);
        return a + b;
    }

    @Test
    public void test() {
        System.out.println("Test");
        System.out.println(add(1,1));
    }

    public static void main(String[] args){

        Person person = new Person("Alice", "Alaska");

        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
    }

}
