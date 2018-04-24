package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 */
public class Servant implements ActiveObject{

    public Result<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++){
            buffer[i] = fillchar;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return new RealResult<String>(new String(buffer));
    }

    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
