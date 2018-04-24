package Future.SampleExample;

/**
 * Created by Damon on 2018/4/23.
 */
public class Host {
    public Data request(final int count, final char c){
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        //futureData实例
        final FutureData futureData = new FutureData();

        //启动线程，创建realData实例
        new Thread(){
            public void run(){
                RealData realData = new RealData(count, c);
                futureData.setRealData(realData);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        //返回futureData实例
        return futureData;
    }
}
