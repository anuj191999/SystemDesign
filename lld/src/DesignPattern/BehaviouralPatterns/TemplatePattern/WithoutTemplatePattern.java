package DesignPattern.BehaviouralPatterns.TemplatePattern;

class JsonDocParser{

    void parseDoc(){
        openFile();
        /*
           Parsing Algorithm here we are performing.
         */
        closeFile();
    }

    public void openFile(){
        System.out.println("JsonDocParser.openFile() :: Opening File");
    }

    public void closeFile(){
        System.out.println("JsonDocParser.closeFile() :: Closing File");
    }
}

class CsvDocParser{

    void parseDoc(){
        openFile();
        /*
           Parsing Algorithm here we are performing.
         */
        closeFile();
    }

    public void openFile(){
        System.out.println("csvDocParser.openFile() :: Opening File");
    }

    public void closeFile(){
        System.out.println("csvDocParser.closeFile() :: Closing File");
    }
}

class SheetDocParser{

    void parseDoc(){
        openFile();
        /*
           Parsing Algorithm here we are performing.
         */
        closeFile();
    }

    public void openFile(){
        System.out.println("csvDocParser.openFile() :: Opening File");
    }

    public void closeFile(){
        System.out.println("csvDocParser.closeFile() :: Closing File");
    }
}

/*
 Cons: suppose if opening and closing file logic is same then chances will be duplicate code.
   Modifying and scaling opening and closing logic will be complex suppose we want to change the file opening logic the in this way i have do modify each file opening logic
 */
public class WithoutTemplatePattern {
    public static void main(String[] args) {

        JsonDocParser parser = new JsonDocParser();
        parser.parseDoc();
    }
}
