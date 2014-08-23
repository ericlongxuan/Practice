import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
wait()方法是Object类里的方法；当一个线程执行到wait()方法时，
它就进入到一个和该对象相关的等待池中，同时失去（释放）了对象的机锁（
暂时失去机锁，wait(long timeout)超时时间到后还需要返还对象锁）；其他线程可以访问；
wait()使用notify或者notifyAlll或者指定睡眠时间来唤醒当前等待池中的线程。
wiat()必须放在synchronized block中，否则会在program runtime时扔出
”java.lang.IllegalMonitorStateException“异常。

wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用
最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。
*/
public class NotifySample {
    public static void main(String[] args){
        JFrame f = new JFrame("Notifyサンプル");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        final JTextField tf = new JTextField();
        tf.setColumns(12);
        f.add(tf);

        //ロック用オブジェクト
        final Object lock = new Object();
        final boolean[] flag = {false};

        //スレッド
        final Thread t = new Thread(){
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        for(int i = 3; i > 0; --i){
                            tf.setText("カウント" + i);
                            Thread.sleep(1000);
                        }
                        tf.setText("待機中");
                        flag[0] = false;
                        while(!flag[0]){
                            lock.wait();
                        }
                        tf.setText("きた！");
                    } catch (InterruptedException ex) {
                        tf.setText("中断");
                    }
                }
            }

        };
        t.start();

        JButton b;
        //再開ボタン
        b = new JButton("再開");
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ボタン押されたらnotify
                synchronized (lock){
                    flag[0] = true;
                    lock.notify();
                }
            }
        });

        //中断
        b = new JButton("中断");
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ボタン押されたらinterrupt
                t.interrupt();
            }
        });

        f.pack();
        f.setVisible(true);
    }
}