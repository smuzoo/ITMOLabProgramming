package parsers;

import validation.Errors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser implements Parsing{

    private final String FILEPATH;
    private final List<String> allCommands = new ArrayList<>();
    private int numberString = -1;
    public FileParser(String FILEPATH) {
        this.FILEPATH = FILEPATH;
        addAllCommands();
    }

    private void addAllCommands(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                allCommands.add(line);
            }
        } catch (IOException e) {
            System.out.println(Errors.IMPOSSIBLEREADFILE);
        }
    }
    @Override
    public String getNewLine() {
        numberString++;
        if(numberString >= allCommands.size()) return null;
        return allCommands.get(numberString);
    }
}
