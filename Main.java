import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        String entry = Files.readString(Paths.get("entry.txt"));
        System.out.println("Here is what I read:");
        System.out.println(entry);

        EntryHistory history = new EntryHistory();
        history.loadFromFile("history.txt");

        history.addEntry(LocalDate.now(), entry);

        history.printAll();
        System.out.println("Entries stored: " + history.size());

        history.saveToFile("history.txt");
    }
}
