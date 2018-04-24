package Future.SampleExample;

import jdk.nashorn.internal.ir.IdentNode;

/**
 * Created by Damon on 2018/4/23.
 */
public class FutureData implements Data {
    private RealData realData = null; //用于保存稍后创建完毕的realData实例，通过setRealData方法设置
    private boolean ready = false;//用于判断是否已经为realData赋值。若为true，表示已经为realData赋值

    /*
     *
     *
     */
    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData = realData;
        this.ready = true;  //
        notifyAll();
    }

    /*
     *
     *
     */
    public synchronized String getContent(){
        while(!ready){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }


}
