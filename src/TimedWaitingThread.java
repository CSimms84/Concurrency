// Scenario for TIME_WAITING state:

/*
    1. Create a thread
    2. Start thread1 via start() method.
    3. In the run() method of thread1, add an arbitrary sleep time.
    4. While thread1 is running, main thread prints thread1 state - the state should
       be TIMED_WAITING since thread1 is in a sleep() that will expire after sleep time.
*/

public class TimedWaitingThread {

    public void timedWaitingThread() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                // log ex
            }
        });
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }

        System.out.println("TimedWaitingThread t: " + thread.getState() + "\n");
    }
}