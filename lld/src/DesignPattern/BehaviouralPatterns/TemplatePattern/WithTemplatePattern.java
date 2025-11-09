package DesignPattern.BehaviouralPatterns.TemplatePattern;

abstract class DocParser{

    public void parse(){
        openFile();
        parseFile();
        closeFile();
    }

    protected abstract void parseFile();
    protected void openFile(){
        System.out.println("DocParser.openFile() :: Opening file...");
    }
    protected void closeFile(){
        System.out.println("DocParser.openFile() :: Closing file...");
    }

}

class JsonDocParserII extends DocParser{

    @Override
    protected void parseFile() {
        System.out.println("JsonDocParserII.parseFile() :: Parsing file...");
    }
}

class CSVDocParserII extends DocParser{

    @Override
    protected void parseFile() {
        System.out.println("CSVDocParserII.parseFile() :: Parsing file...");
    }

    @Override
    protected void openFile() {
        System.out.println("CSVDocParserII.openFile() :: Parsing file...");
    }
}

public class WithTemplatePattern {

    public static void main(String[] args) {
//        DocParser docParser = new JsonDocParserII();
//        docParser.parse();
        CSVDocParserII docParser = new CSVDocParserII();
        docParser.parse();
    }
}
