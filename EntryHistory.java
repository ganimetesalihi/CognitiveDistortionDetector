import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class EntryHistory {
    private final Map<LocalDate, String> entries = new TreeMap<>();

    public void addEntry(LocalDate date, String text) {
        entries.put(date, text);
    }

    public void printAll() {
        for (Map.Entry<LocalDate, String> e : entries.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public int size() {
        return entries.size();
    }
}