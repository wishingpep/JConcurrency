package Java_concurrency_in_practice.other.threadandrunnable;

public class Thread_direct_start {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        t.start();
        t.start();
/*
控制台输出结果如下：

Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:708)
	at Java_concurrency_in_practice.other.threadandrunnable.MyThread.main(MyThread.java:7)
Thread id is 11 ,Thread name is Thread-0 ,this is the 10 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 9 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 8 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 7 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 6 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 5 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 4 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 3 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 2 time call run method.
Thread id is 11 ,Thread name is Thread-0 ,this is the 1 time call run method.

Process finished with exit code 1

调用多次start方法，实际上只启动了一个线程，还抛了异常 IllegalThreadStateException
而当把代码修改成仅仅调用一次start方法，就不会抛异常，输出跟之前调多次是一致的。
这是为什么？
我们可以debug跟进到报异常的代码，如下：

public synchronized void start() {
         * A zero status value corresponds to state "NEW".
        if (threadStatus != 0)
            throw new IllegalThreadStateException();

因为第一次调用start方法后，线程的状态由初始化的0变成了RUNNABLE非0，所以在第二次调用start时，会throw异常结束主线程main方法

如果把多余的 start() 方法都注释掉，只保留一个，就不会有异常。但是，这个程序依然是单线程的，继承Thread就没有任何意义
*/
    }
}