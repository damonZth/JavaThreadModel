package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * 与MakeClientObjectThread一样，用来使用ActiveObject对象的线程类
 *
 * DisplayClientThread调用主动对象ActiveObject的displayString
 *
 * displayString方法会在被调用后立即返回。即将“显示字符串”这个异步消息传递个主动对象
 */
public class DisplayClientThread extends Thread {
    //activeObject字段保存ActiveObject对象，MakerClientThread调用该对象的displayString方法
    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject){
        super(name);//线程名
        this.activeObject = activeObject;
    }

    public void run(){
        try{
            for(int i = 0; true; i++){
                //没有返回值的调用
                String string = Thread.currentThread().getName() + " " + i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
