import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResourcePool {

    private final BlockingQueue<ExpensiveResource> pool;

    public ResourcePool(int size) {

        pool = new ArrayBlockingQueue<>(size);

        for (int i = 1; i <= size; i++) {

            pool.add(
                    new ExpensiveResource(i)
            );
        }
    }

    public Lease acquire(
            long timeout,
            TimeUnit unit
    ) throws InterruptedException,
             TimeoutException {

        ExpensiveResource resource =
                pool.poll(timeout, unit);

        if (resource == null) {

            throw new TimeoutException(
                    "Brak wolnego zasobu"
            );
        }

        return new Lease(resource);
    }

    public int availableResources() {
        return pool.size();
    }

    public class Lease
            implements AutoCloseable {

        private ExpensiveResource resource;

        private Lease(
                ExpensiveResource resource
        ) {
            this.resource = resource;
        }

        public ExpensiveResource get() {

            if (resource == null) {
                throw new IllegalStateException(
                        "Zasób został już zwrócony"
                );
            }

            return resource;
        }

        @Override
        public void close() {

            if (resource != null) {

                pool.offer(resource);

                resource = null;
            }
        }
    }
}
