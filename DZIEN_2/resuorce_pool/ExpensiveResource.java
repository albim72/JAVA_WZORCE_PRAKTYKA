public class ExpensiveResource {

    private final int id;

    public ExpensiveResource(int id) {

        this.id = id;

        System.out.println(
                "Tworzę zasób " + id
        );
    }

    public void execute() {

        System.out.println(
                "Pracuje zasób " + id
        );
    }

    public int getId() {
        return id;
    }
}
