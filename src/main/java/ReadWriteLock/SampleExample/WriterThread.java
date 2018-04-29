package ReadWriteLock.SampleExample;

import java.util.Random;

/**
 * Created by Damon on 2018/4/29.
 */
public class WriterThread extends Thread{
    private static final Random random = new Random();

    private final Data data;
    private final String filler;

    private int index = 0;

    public WriterThread(Data data, String filler){
        this.data = data;
        this.filler = filler;
    }

    public void run(){
        try{
            while (true){
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c = filler.charAt(index);
        index ++;
        if(index >= filler.length()){
            index = 0;
        }
        return c;
    }
}
