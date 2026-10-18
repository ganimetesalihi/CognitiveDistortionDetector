import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    // Save every entry as one line: date|text
    public void saveToFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<LocalDate, String> e : entries.entrySet()) {
            String oneLine = e.getValue().strip().replace("\r", "").replace("\n", " ");
            lines.add(e.getKey() + "|" + oneLine);
        }
        Files.write(Paths.get(fileName), lines);
    }

    // Read entries back from the file, if it exists
    public void loadFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            return;
        }
        for (String line : Files.readAllLines(path)) {
            String[] parts = line.split("\\|", 2);
            if (parts.length == 2) {
                entries.put(LocalDate.parse(parts[0]), parts[1]);
            }
        }
    }
}
