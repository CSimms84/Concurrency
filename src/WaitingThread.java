// Examples for WAITING state:

/*
    1. Create a thread.
    2. Start thread1 via start().
    3. In run() method of thread1:
        1. Create another thread (thread2).
        2. Start thread2 via start().
        3. While thread2 is running, call thread2.join() since thread2 needs to join thread1
           (thread1 needs to wait for thread2 to die)
    4. In run() method of thread2, thread2 prints state of thread1, which should be
    WAITING (while printing the thread1 state, thread2 is running, therefore thread1 is waiting).
*/

public class WaitingThread {

    private static final Thread thread1 = new CodeT1();

    public void waitingThread() {
        thread1.start();
    }

    private static class CodeT1 extends Thread {

        @Override
        public void run() {
            Thread thread2 = new Thread(new CodeT2());
            thread2.start();

            try {
                thread2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        }
    }

    private static class CodeT2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }

            System.out.println("WaitingThread t1: " + thread1.getState() + " \n");
        }
    }
}

/*
// Alternative implementation
public void waitingThread() {
        new Thread(() -> {
            Thread t1 = Thread.currentThread();
            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("WaitingThread t1: " + t1.getState() + "\n");
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // log ex
                }
            });
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        }).start();
}
*/
