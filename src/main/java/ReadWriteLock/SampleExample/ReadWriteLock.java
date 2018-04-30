package ReadWriteLock.SampleExample;

/**
 * Created by Damon on 2018/4/29.
 */
public class ReadWriteLock {
    private int readingReaders = 0;//实际正在读取的线程的个数
    private int waitingWriters = 0;//正在等待写入的线程个数
    private int writingWriters = 0; //实际正在写入中的线程的个数
    private boolean preferWriter = true;//若写入优先，则为true


    public synchronized void readLock() throws InterruptedException {
        while(writingWriters > 0 || (preferWriter && waitingWriters >0)){
            wait();
        }
        readingReaders ++;
    }


    public synchronized void readUnLock() {
        readingReaders --;
        preferWriter = true;
        notifyAll();
    }


    public synchronized void writeLock() throws InterruptedException {
        waitingWriters ++;
        try{
            while (readingReaders > 0 || waitingWriters > 0){
                wait();
            }
        }finally {
            waitingWriters --;
        }
        waitingWriters ++;
    }


    public synchronized void writeUnLock() {
        writingWriters --;
        preferWriter = false;
        notifyAll();
    }
}
