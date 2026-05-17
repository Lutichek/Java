package lr6;

public class Example3 {
    private static final Object lock = new Object();
    private static int number = 0;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (number < 10) {
                    if (number % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (number < 10) {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        evenThread.setName("EvenThread");
        oddThread.setName("OddThread");
        evenThread.start();
        oddThread.start();
    }
}
