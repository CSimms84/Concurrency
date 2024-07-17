package ThreadLifecycles;
/*
  Code below contains snippets of code
  that reveals the NEW state via different
  construction techniques, including lambdas.
 */

public class NewThread {

    public void newThread() {

        // construction 1
        Thread thread1 = new Thread(() -> {
        });
        System.out.println("New thread thread1: " + thread1.getState());

        // construction 2
        Runnable runnable1 = () -> {
        };
        Thread thread2 = new Thread(runnable1);
        System.out.println("New thread thread2: " + thread2.getState());

        // construction 3
        Thread thread3 = new Thread(() -> {
        });
        System.out.println("New thread thread3: " + thread3.getState());

        // construction 4
        Thread thread4 = new Thread(new Thread(() -> {
        }));
        System.out.println("New thread thread4: " + thread4.getState() + "\n");
    }
}
