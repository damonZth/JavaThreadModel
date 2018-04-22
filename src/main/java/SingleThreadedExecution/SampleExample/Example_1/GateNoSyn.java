package SingleThreadedExecution.SampleExample.Example_1;

import javax.swing.*;

/**
 * Created by Damon on 2018/4/22.
 *
 * 非线程安全的Gate
 *
 * 模拟三个人通过一扇每次只能允许一个人通过的门。
 * 当有人通过时，统计人数，且记录通行者的信息（姓名与出生地）
 *
 * Alice： Alaska
 * Bobby： Brazil
 * Chris： Canada
 *
 */
public class GateNoSyn extends AbstarctGate{
    private int counter = 0;//用于记录通过Gate人数
    private String name = "Nobody";
    private String address = "NoWhere";

    public void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("*********** BROKEN  ***********" + this.toStr());
        }else{
            System.out.println("*********** OK  ***********" + this.toStr());
        }
    }

    public String toStr(){
        return "No." + counter + " : " + name + "-->" + address;
    }

}
