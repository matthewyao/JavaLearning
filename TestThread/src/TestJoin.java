/**
 * Created by matthewyao on 2016/5/3.
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread t2 = new Thread(new Thread2());
        t2.start();
        try {
            /**join方法即为将t2线程合并到main线程中，则main线程必须等待t2执行完毕后才能继续执行*/
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am MainThread");
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am Thread2");
        }
    }
}
