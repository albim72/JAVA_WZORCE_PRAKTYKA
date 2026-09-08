import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args)
            throws Exception {

        ResourcePool pool =
                new ResourcePool(2);

        try (
            ResourcePool.Lease lease =
                pool.acquire(
                        1,
                        TimeUnit.SECONDS
                )
        ) {

            lease.get().execute();
        }

        System.out.println(
                "Wolne: "
                + pool.availableResources()
        );
    }
}
