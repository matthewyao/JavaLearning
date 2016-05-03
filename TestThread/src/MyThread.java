/**
 * Created by matthewyao on 2016/5/3.
 */
public class MyThread {
    public static void main(String[] args) {
//        new Thread1().run();
        Thread t1 = new Thread(new Thread1());
        t1.start();
    }
}

class Thread1 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am Thread1");
        }
    }
}
