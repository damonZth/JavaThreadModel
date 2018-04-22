package SingleThreadedExecution.SampleExample.Example_1;

/**
 * Created by Damon on 2018/4/22.
 */
public class UserThread extends Thread {

    private AbstarctGate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(AbstarctGate gate, String myName, String myAddress) {
        this.gate = gate;
        this.myName = myName;
        this.myAddress = myAddress;
    }


    public void run(){
        System.out.println( myName + "线程" + "*******  BEGIN  *******");
        while(true){
            gate.pass(myName, myAddress);
        }

    }
}
