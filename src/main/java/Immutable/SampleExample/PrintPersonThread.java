package Immutable.SampleExample;

/**
 * Created by Damon on 2018/4/27.
 */
public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person){
        this.person = person;
    }

    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName() + "prints: " + person);
        }
    }
}
