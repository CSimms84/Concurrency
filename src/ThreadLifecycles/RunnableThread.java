package ThreadLifecycles;
// Scenario for the RUNNABLE state:

/*
    The code below should print RUNNABLE, since we print the state of
    the thread after calling start(). However, because of thread-scheduler internal
    mechanisms, this isn't guaranteed.
*/

public class RunnableThread {

    public void runnableThread() {
        Thread thread1 = new Thread(() -> {
        });
        thread1.start();

        System.out.println("RunnableThread thread1: " + thread1.getState());

        Runnable runnable1 = () -> {
        };
        Thread thread2 = new Thread(runnable1);
        thread2.start();
        System.out.println("RunnableThread thread2: " + thread2.getState());

        Thread thread3 = new Thread(() -> {
        });
        thread3.start();
        System.out.println("RunnableThread t3: " + thread3.getState());

        Thread thread4 = new Thread(new Thread(() -> {
        }));
        thread4.start();
        System.out.println("RunnableThread t4: " + thread4.getState() + "\n");
    }

}