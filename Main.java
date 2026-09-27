import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String entry = Files.readString(Paths.get("entry.txt"));
        System.out.println("Here is what I read:");
        System.out.println(entry);
    }
}
