/**
sleep()使当前线程进入停滞状态（阻塞当前线程），让出CUP的使用、
目的是不让当前线程独自霸占该进程所获的CPU资源，以留一定时间给其他线程执行的机会;
　　 sleep()是Thread类的Static(静态)的方法；因此他不能改变对象的机锁，
所以当在一个Synchronized块中调用Sleep()方法是，线程虽然休眠了，
但是对象的机锁并木有被释放，其他线程无法访问这个对象（即使睡着也持有对象锁）。
　　在sleep()休眠时间期满后，该线程不一定会立即执行，
这是因为其它线程可能正在运行而且没有被调度为放弃执行，除非此线程具有更高的优先级。 
sleep必须捕获异常

wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，
而sleep可以任何地方使用
最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。
*/


class ThreadTest1 extends Thread{

   boolean ready= false;

   public void run() {
      String thrdName = Thread.currentThread().getName();
      System.out.println(thrdName + " starting.");
      System.out.println("waiting...");

      startWait();
      try {
         Thread.sleep(1000);
      }
      catch(Exception exc) {
         System.out.println(thrdName + " interrupted.");
      }
      System.out.println(thrdName + " terminating.");
   }
   synchronized void startWait() {
      try {
         while(!ready) wait();
      }
      catch(InterruptedException exc) {
         System.out.println("wait() interrupted");
      }
   }
   synchronized void notice() {
      ready = true;
      notify();
   }
}
public class ThreadTest1Main {
   public static void main(String args[]) 
   throws Exception{
      ThreadTest1 thrd = new ThreadTest1();
      thrd.setName("ThreadTest1 #1");
      //ThreadTest1 #1 Alive:false State:NEW
      showThreadStatus(thrd);

      //starting.
      thrd.start();
      //waiting...

      Thread.sleep(50);
      //ThreadTest1 #1 Alive:true State:WAITING
      showThreadStatus(thrd);

      thrd.notice();
      Thread.sleep(50);
      //ThreadTest1 #1 Alive:true State:TIMED_WAITING
      showThreadStatus(thrd);
      //ThreadTest1 #1 Alive:true State:TIMED_WAITING
      showThreadStatus(thrd);

      //ThreadTest1 #1 terminating.
   }
   static void showThreadStatus(Thread thrd) {
      System.out.println(thrd.getName()+" Alive:"
      +thrd.isAlive()+" State:" + thrd.getState() );
   }
}