package lr6;

public class Example4 {
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("Поток: " + count);
                    count++;
                }
            });

            thread.start();
        }
    }
}