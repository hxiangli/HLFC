package com.hlfc.thread.synch;

/**
 * 参考：https://www.cnblogs.com/wl0000-03/p/5973039.html
 * 对象同步锁
 * @author HXL
 * @since 2018-11-16
 */

public class ObjSynchronized
{
    public  void test1()
    {
        //代码块锁
        synchronized(this)
        {
            int i = 5;
            while( i-- > 0)
            {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException ie)
                {
            }
            }
        }
    }

    //方法锁
    public  void test2()
    {
        int i = 5;
        while( i-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
            }
        }
    }
    public static void main(String[] args)
    {
        final ObjSynchronized myt2 = new ObjSynchronized();
        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test1();   }  }, "test2"  );
        test1.start();
        test2.start();

    }
}

