package parsers;


/**
 * The type Parser controller.
 */
public class ParserController implements Parsing {

    private Parsing parser;
    private NameParser nameParser;

    /**
     * Instantiates a new Parser controller.
     *
     * @param parser     the parser
     * @param nameParser the name parser
     */
    public ParserController(Parsing parser, NameParser nameParser) {
        this.parser = parser;
        this.nameParser = nameParser;
    }

    /**
     * Gets parser.
     *
     * @return the parser
     */
    public Parsing getParser() {
        return parser;
    }

    /**
     * Sets parser.
     *
     * @param parser the parser
     */
    public void setParser(Parsing parser) {
        this.parser = parser;
    }

    /**
     * Gets name parser.
     *
     * @return the name parser
     */
    public NameParser getNameParser() {
        return nameParser;
    }

    /**
     * Sets name parser.
     *
     * @param nameParser the name parser
     */
    public void setNameParser(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public String getNewLine() {
        String request = parser.getNewLine();
        if (request == null) {
            setParser(new ConsoleParser());
            setNameParser(NameParser.PARSERCONSOLE);
            request = parser.getNewLine();
        }
        return request;
    }


}
