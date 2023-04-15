package Parsers;


public class ParserController  {

    public void setParser(Parsing parser) {
        this.parser = parser;
    }

    public void setNameParser(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    private Parsing parser;


    private NameParser nameParser;


    public Parsing getParser() {
        return parser;
    }

    public NameParser getNameParser() {
        return nameParser;
    }

    public ParserController(Parsing parser, NameParser nameParser) {
        this.parser = parser;
        this.nameParser = nameParser;
    }


    public String getNewLine() {
        String request = parser.getNewLine();
        if(request == null){
        setParser(new ConsoleParser());
        setNameParser(NameParser.PARSER_CONSOLE);
        }
        return request;
    }


}
