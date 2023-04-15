package Parsers;


public class ParserController extends Parser {

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setNameParser(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    private Parser parser;


    private NameParser nameParser;


    public Parser getParser() {
        return parser;
    }

    public NameParser getNameParser() {
        return nameParser;
    }

    public ParserController(Parser parser, NameParser nameParser) {
        this.parser = parser;
        this.nameParser = nameParser;
    }


    @Override
    public String getNewLine() {
        String request = parser.getNewLine();
        if(request == null){
        setParser(new ConsoleParser());
        setNameParser(Parsers.NameParser.PARSER_CONSOLE);
        }
        return request;
    }


}
