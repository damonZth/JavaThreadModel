package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 *
 * 调用主动对象的makeString方法的线程
 *
 * makeString方法在调用后立即返回。此处的调用，指将“生成字符串”这个异步消息传递给主动对象。
 * makeString方法的返回值是一个Result类型。使用的事Future的多线程模式，使用getResultValue方法来获取实际的返回结果。
 */
public class MakerClientThread extends Thread{
    //activeObject字段保存ActiveObject对象，MakerClientThread调用该对象的makeString方法
    private final ActiveObject activeObject;
    private final char fillcahr;

    public MakerClientThread(String name, ActiveObject activeObject){
        super(name);//线程名
        this.activeObject = activeObject;
        this.fillcahr = name.charAt(0);//使用线程名的第一个字符作为填充字符
    }

    public void run(){
        try{
            for(int i = 0; true; i++){
                //有返回值的调用
                Result<String> result = activeObject.makeString(i, fillcahr);
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName() + " :·value = "+ value);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
