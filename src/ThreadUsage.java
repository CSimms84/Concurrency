public class ThreadUsage {
    public static void main(String args[]) {
        for (int i = 0; i < 99; i++) {
            new Thread() {
                public void run() {
                    System.out.println("Sleeping... " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000000000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}