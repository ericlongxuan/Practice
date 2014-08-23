import java.util.Date;

/**
这个例子中在一个local方法里 定义两个线程类， 开启一个线程兵用另一个去中断
同时展示了LocalInnerClass和anonymous inner class
*/
public class LocalInner {
	private String x = "outer";
 
	public void demo() {
		class PrintRun implements Runnable{
			public void run() {
				try{
					while(true){
						System.out.println("time is " + new Date());
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e){
					System.out.println("interupted");
				}
				System.out.println("finish");
			}
		}

		//This is an anonymous inner class
		new Thread(new Runnable() {
            public void run() {
                Thread pr = new Thread(new PrintRun());
				pr.start();
				try{
					Thread.sleep(5000);
					pr.interrupt();
				}
				catch(InterruptedException e){
					System.out.println("main interupted");
				}
				
            }
        }).start();
	}


 	/**
 	time is Mon Mar 17 13:33:32 JST 2014
	time is Mon Mar 17 13:33:33 JST 2014
	time is Mon Mar 17 13:33:34 JST 2014
	time is Mon Mar 17 13:33:35 JST 2014
	time is Mon Mar 17 13:33:36 JST 2014
	interupted
	finish
 	*/
	public static void main(String[] args) {
		LocalInner o = new LocalInner();
		o.demo();
	}
}