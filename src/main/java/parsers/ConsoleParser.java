package parsers;


import java.util.Locale;
import java.util.Scanner;

public class ConsoleParser implements Parsing {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getNewLine() {
        return scanner.nextLine().toLowerCase(Locale.ROOT);

    }
}
