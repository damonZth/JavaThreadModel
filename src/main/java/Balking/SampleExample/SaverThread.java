package Balking.SampleExample;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;

/**
 * Created by Damon on 2018/4/28.
 */
public class SaverThread extends Thread{
    private final Data data;

    public SaverThread(String name, Data data){
        super(name);
        this.data = data;
    }

    public void run(){
        try{
            while(true){
                data.save();//保存数据
                Thread.sleep(1000);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
