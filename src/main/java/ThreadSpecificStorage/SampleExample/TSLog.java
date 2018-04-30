package ThreadSpecificStorage.SampleExample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Damon on 2018/4/30.
 */
public class TSLog {
    private PrintWriter writer = null;

    //初始化字段
    public TSLog(String fileName){
        try{
            writer = new PrintWriter(new FileWriter(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //写日志
    public void println(String s){
        writer.println(s);
    }

    //关闭日志
    public void close(){
        writer.println("******** end of log ********");
        writer.close();
    }
}
