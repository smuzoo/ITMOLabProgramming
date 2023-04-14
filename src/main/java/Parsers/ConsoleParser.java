package Parsers;


import java.util.Scanner;

public class ConsoleParser extends Parser {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getNewLine() {
        lastLine = scanner.nextLine();
        return lastLine;
    }
}
