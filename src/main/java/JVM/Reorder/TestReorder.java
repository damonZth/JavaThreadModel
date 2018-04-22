package JVM.Reorder;

/**
 * Created by Damon on 2018/4/22.
 */
public class TestReorder {

    /**
     *  重排序，Reorder，指编译器和Java虚拟机通过改变程序的处理顺序来优化程序。
     *
     *  重排序能够被广泛应用于提高程序的性能。
     *  但是在运行单线程程序的时候，我们无法判断是否进行了重排序，因为虽然处理顺序改变了，
     *  但是规范上有很多限制可以避免程序出现运行错误。
     *
     */

    public static void main(String[] args){
        final Something something = new Something();

        //写数据线程A ----- 匿名内部类
        new Thread(){
            public void run(){
                something.write();
            }
        }.start();

        //读数据线程B ---- 匿名内部类
        new Thread(){
            public void run(){
                something.read();
            }
        }.start();
    }
}

class Something{
    private int x = 0;
    private int y = 0;

    public void write(){
        x = 100;
        y = 50;
    }

    public void read(){
        if(x < y){
            System.out.println("x < y");
        }else {
            System.out.println("x > y");
        }
    }
}
