import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleThreadPoolExecutor implements Runnable {

    private static final Logger logger = Logger.getLogger(SimpleThreadPoolExecutor.class.getName());
    private final int taskId;

    public SimpleThreadPoolExecutor(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            logger.info("Executing task " + taskId + " via " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Task interrupted", ex);
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);

        final AtomicInteger counter = new AtomicInteger();
        ThreadFactory threadFactory = (Runnable r) -> {
            String threadName = "Cool-Thread-" + counter.incrementAndGet();
            logger.info("Creating a new " + threadName);
            return new Thread(r, threadName);
        };

        RejectedExecutionHandler rejectedHandler = (Runnable r, ThreadPoolExecutor executor) -> {
            if (r instanceof SimpleThreadPoolExecutor) {
                SimpleThreadPoolExecutor task = (SimpleThreadPoolExecutor) r;
                logger.warning("Rejecting task " + task.taskId);
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                ThreadPoolConfig.CORE_POOL_SIZE,
                ThreadPoolConfig.MAX_POOL_SIZE,
                ThreadPoolConfig.KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                queue,
                threadFactory,
                rejectedHandler
        );

        for (int i = 0; i < 50; i++) {
            executor.execute(new SimpleThreadPoolExecutor(i));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(ThreadPoolConfig.AWAIT_TERMINATION_TIMEOUT, TimeUnit.MILLISECONDS)) {
                logger.warning("Executor did not terminate in the specified time.");
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Termination interrupted", ex);
            executor.shutdownNow();
        }
    }
}

class ThreadPoolConfig {
    static final int CORE_POOL_SIZE = 10;
    static final int MAX_POOL_SIZE = 20;
    static final long KEEP_ALIVE_TIME = 1;
    static final long AWAIT_TERMINATION_TIMEOUT = Integer.MAX_VALUE;
}
