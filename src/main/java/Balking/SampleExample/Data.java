package Balking.SampleExample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Damon on 2018/4/28.
 */
public class Data {
    private final String fileName;//文件名
    private String content;//数据内容

    private boolean changed;//数据是否被保存，修改后的内容未保存则为true

    public Data(String fileName, String content){
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    //修改数据
    public synchronized void change(String newContent){
        content = newContent;
        changed = true;
    }

    //保存数据
    public synchronized void save()throws IOException{
        if(!changed){
            return;
        }
        doSave();
        changed = false;
    }

    //将数据内容实际保存到文件中
    private void doSave()throws IOException{
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }


}
