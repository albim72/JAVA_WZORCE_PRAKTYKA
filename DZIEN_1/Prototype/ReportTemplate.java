import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportTemplate {

    private List<String> sections;
    private Map<String, String> settings;

    public ReportTemplate(List<String> sections,
                          Map<String, String> settings) {

        this.sections = sections;
        this.settings = settings;
    }

    // KOPIA PŁYTKA
    public ReportTemplate shallowCopy() {

        return new ReportTemplate(
                this.sections,
                this.settings
        );
    }

    // KOPIA GŁĘBOKA
    public ReportTemplate deepCopy() {

        return new ReportTemplate(
                new ArrayList<>(this.sections),
                new HashMap<>(this.settings)
        );
    }

    public List<String> getSections() {
        return sections;
    }

    public Map<String, String> getSettings() {
        return settings;
    }
}
