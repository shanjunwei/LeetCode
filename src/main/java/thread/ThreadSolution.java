package thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadSolution {
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            while (true){
                while (flag.get()) {
                    System.out.println("a");
                    flag.set(false);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            while (true){
                while (!flag.get()) {
                    System.out.println("b");
                    flag.set(true);
                }
            }
        });
        thread2.start();
    }
}
