package ThreadLifecycles;
// Scenario for TERMINATED state

/*
    The main thread of the app prints the state of the thread.
    While this is happening, the thread has done its job
 */

public class TerminatedThread {
    public void terminatedThread() {

        Thread thread = new Thread(() -> {
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }

        System.out.println("TerminatedThread thread: " + thread.getState() + "\n");
    }
}
