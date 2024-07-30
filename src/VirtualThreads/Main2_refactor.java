import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2_refactor {
    private static final Logger logger = LoggerFactory.getLogger(Main2.class);

    public static void main(String[] args) {
        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create a virtual thread
        Thread vThread = Thread.ofVirtual().name("my-virtual-thread").unstarted(() -> {
            logger.info("Virtual thread started");
            // Perform some task
            logger.info("Virtual thread finished");
        });

        // Create a platform thread
        Thread pThread = Thread.ofPlatform().name("my-platform-thread").unstarted(() -> {
            logger.info("Platform thread started");
            // Perform some task
            logger.info("Platform thread finished");
        });

        // Submit threads to the thread pool
        executor.execute(vThread);
        executor.execute(pThread);

        // Shut down the thread pool
        executor.shutdown();
    }
}