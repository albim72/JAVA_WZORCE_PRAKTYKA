public class Main {

    public static void main(String[] args)
            throws Exception {

        ResourcePool pool =
                new ResourcePool(2);

        System.out.println(
                pool.availableResources()
        );

        try (
            ResourcePool.Lease lease =
                pool.acquire(
                        1,
                        java.util.concurrent.TimeUnit.SECONDS
                )
        ) {

            System.out.println(
                    "Używam zasobu "
                    + lease.get().getId()
            );

            throw new RuntimeException(
                    "BUM!"
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "Wystąpił wyjątek"
            );
        }

        System.out.println(
                "Wolne po wyjątku: "
                + pool.availableResources()
        );
    }
}
