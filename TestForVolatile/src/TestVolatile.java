/**
 * Created by matthewyao on 2016/5/4.
 */
public class TestVolatile {

    static int a=0, b=1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();

        while (true){
            if (a == 0 && b == 0){
                System.out.println("a and b both are zero!");
            }
        }
    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            if (a == 0 && b == 1){
                a++;
                b--;
            }
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            if (a == 1 && b == 0){
                b++;
                a--;
            }
        }
    }
}

