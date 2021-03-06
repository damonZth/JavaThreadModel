package ThreadPerMessage.SampleExample;

/**
 * Created by Damon on 2018/4/30.
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c){
        System.out.println("    request(" + count + ", " + c + ") beging");
        new Thread(){
            public void run(){
                helper.handle(count, c);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + ") end");
    }
}
