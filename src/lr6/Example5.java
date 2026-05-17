package lr6;

public class Example5 {
    private static int max = Integer.MIN_VALUE;

    public static int findMax(int[] array) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        int size = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * size;
            final int end = (i == numThreads - 1) ? array.length : (i + 1) * size;
            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                synchronized (Example5.class) {
                    if (localMax > max) {
                        max = localMax;
                    }
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {3, 7, 2, 8, 5, 9, 1, 4, 6, 100, 63, 10, 20, 30, 40, 50, 60, 70, 80, 90, 1000, 2000};
        int max = findMax(array);
        System.out.println("Максимальный элемент в массиве: " + max);
    }
}
