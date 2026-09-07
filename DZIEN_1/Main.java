import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        var sections = new ArrayList<String>();

        sections.add("Wstęp");
        sections.add("Sprzedaż");

        var settings = new HashMap<String, String>();

        settings.put("language", "PL");
        settings.put("format", "PDF");

        ReportTemplate prototype =
                new ReportTemplate(sections, settings);


        // ---------------------------
        // KOPIA PŁYTKA
        // ---------------------------

        ReportTemplate shallow =
                prototype.shallowCopy();

        shallow.getSections().add("BONUS");

        System.out.println(
                prototype.getSections()
        );

        // [Wstęp, Sprzedaż, BONUS]
        //
        // Problem!
        // Modyfikacja kopii zmieniła prototyp.


        // ---------------------------
        // KOPIA GŁĘBOKA
        // ---------------------------

        ReportTemplate deep =
                prototype.deepCopy();

        deep.getSections().add("AUDYT");

        System.out.println(
                deep.getSections()
        );

        System.out.println(
                prototype.getSections()
        );
    }
}
