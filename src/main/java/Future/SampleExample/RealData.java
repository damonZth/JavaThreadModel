package Future.SampleExample;

/**
 * Created by Damon on 2018/4/23.
 */
public class RealData implements Data {
    private final String content;//请求处理的结果

    public RealData(int count, char c) {
        System.out.println("    making ReakData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++){
            buffer[i] = c;
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
        System.out.println("    making ReakData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }

    public String getContent(){
        return content;
    }
}
