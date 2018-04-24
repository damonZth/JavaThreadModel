package ActiveObject.SampleExample;

/**
 * Created by Damon on 2018/4/24.
 */
public class DisplayStringRequest extends MethodRequest<Object>{
    private final String string;

    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }

    public void execute() {
        servant.displayString(string);
    }
}
