package ProducerConsumer.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/29.
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;//记录蛋糕的流水号,(共用)

    public MakerThread(String name, Table table, long seed){
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run(){
        try{
            while(true){
                Thread.sleep(random.nextInt(1000));
                String cake = "Cake NO." + nextId() + " by " + getName() + "]";
                table.put(cake);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //这里为什么要用synchronized
    private static synchronized int nextId(){
        return id ++;
    }
}
