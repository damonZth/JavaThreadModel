package GuardedSuspension.SampleExample;

/**
 * Created by Damon on 2018/4/27.
 */
public class Request {
    private final String name;

    public Request(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "[ Request " + name + "]";
    }
}
