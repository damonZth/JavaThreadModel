package Immutable.SampleExample;

/**
 * Created by Damon on 2018/4/27.
 */
public class Person {
    private final String name;
    private final String address;


    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }

    public String toString(){
        return "[Person: name = " + name + ", address = " + address + " ]";
    }
}
