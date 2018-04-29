package Balking.SampleExample;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Damon on 2018/4/28.
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data){
        super(name);
        this.data = data;
    }

    public void run(){
        try {
            for (int i = 0; true; i++) {
                data.change("NO." + i);//修改数据
                Thread.sleep(1000);
                data.save();
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
