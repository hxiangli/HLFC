package com.hlfc.thread.synch;

/**
 * 对比类锁与对象锁。互不影响，可以交替进行
 * @Auther: HXL
 * @Date: 2018/11/16 16:10
 */
public class ObjClassSynchronized
{
    public synchronized void test1()
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
    public static synchronized void test2()
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
        final ObjClassSynchronized myt2 = new ObjClassSynchronized();
        Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { ObjClassSynchronized.test2();   }  }, "test2"  );
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }
}
