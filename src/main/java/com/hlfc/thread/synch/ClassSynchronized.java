package com.hlfc.thread.synch;

/**
 * 参考：https://www.cnblogs.com/wl0000-03/p/5973039.html
 * 类同步锁
 * @author HXL
 * @since 2018-11-16
 */

public class ClassSynchronized
{  
    public void test1() 
    {
        /**
         * 代码块锁
         */
        synchronized(ClassSynchronized.class)
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
         final ClassSynchronized myt2 = new ClassSynchronized();
         Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );  
         Thread test2 = new Thread(  new Runnable() {  public void run() { ClassSynchronized.test2();   }  }, "test2"  );
         test1.start();  
         test2.start();  
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    } 
}
