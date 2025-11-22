package DesignPattern.StructurePatterns.AdaptorPattern;
interface Printer{
    void print();
}
class LegacyPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing by legacy printer");
    }
}

class PrinterAdapter implements Printer{
    private LegacyPrinter legacyPrinter;
    PrinterAdapter(LegacyPrinter legacyPrinter){
        this.legacyPrinter=legacyPrinter;
    }
    @Override
    public void print() {
        legacyPrinter.print();
    }
}

public class client {
    public static void main(String[] args) {
        PrinterAdapter printerAdapter=new PrinterAdapter(new LegacyPrinter());
        printerAdapter.print();
    }
}
