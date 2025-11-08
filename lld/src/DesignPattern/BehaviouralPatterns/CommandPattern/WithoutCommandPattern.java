package DesignPattern.BehaviouralPatterns.CommandPattern;

class TextEditor{

    public void boldText(){
        System.out.println("Text has been bolded");
    }

    public void italicizeText(){
        System.out.println("Text has been italicized");
    }
    public void underlineText(){
        System.out.println("Text has been underlined");
    }
}

// ui button classes;

class BoldButton{

    private TextEditor textEditor;
    public BoldButton(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    public void click(){
        textEditor.boldText();
    }
}

class ItalicButton{
    private TextEditor textEditor;
    public ItalicButton(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    public void click(){
        textEditor.italicizeText();
    }
}



public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        BoldButton boldButton=new BoldButton(editor);
        ItalicButton italicButton=new ItalicButton(editor);
        boldButton.click();
        italicButton.click();
    }
}
