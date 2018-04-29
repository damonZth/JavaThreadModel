package ReadWriteLock.SampleExample;

/**
 * Created by Damon on 2018/4/29.
 */
public class Data {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size){
        this.buffer = new char[size];
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException{
        lock.readLock();
        try{
            return doRead();
        }finally {
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException{
        lock.writeLock();
        try{
            doWrite(c);
        }finally {
            lock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = c;
            slowly();
        }

    }

    private char[] doRead() {
        char[] newBuff = new char[buffer.length];
        for(int i = 0; i < buffer.length; i++){
            newBuff[i] = buffer[i];
        }
        slowly();
        return newBuff;
    }

    private void slowly() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
