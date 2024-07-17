package ThreadLifecycles;
// Creating a BLOCKED state

/*
   1) Create two threads: thread1 and thread2
   2) Start thread1 via start() method:
       a) thread1 executes run() method and will acquire lock
          for synced method, syncMethod().
       b) Because it has an infinite loop, syncMethod()
          keeps thread1 inside forever.
   3) After arbitrary amount of time, start thread2 via start() method:
       a) thread2 executes run() and will end up in BLOCKED state because
          it can't acquire the lock of syncMethod().
 */

public class BlockedThread {

    public void blockThread() {
        Thread thread1 = new Thread(new SyncBlockCode());
        Thread thread2 = new Thread(new SyncBlockCode());

        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }

        System.out.println("Blocked thread thread1: "
                + thread1.getState() + "(" + thread1.getName() + ")");
        System.out.println("Blocked thread thread2: "
                + thread2.getState() + "(" + thread2.getName() + ")");

        System.exit(0);
    
    }

    private static class SyncBlockCode implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread "
                    + Thread.currentThread().getName() + " is in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread "
                    + Thread.currentThread().getName() + " is in syncMethod() method");
            while (true) {
                // thread1 stays here forever, which means thread2 is blocked
            }
        }
    }
}
