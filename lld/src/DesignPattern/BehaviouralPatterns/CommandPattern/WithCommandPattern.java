package DesignPattern.BehaviouralPatterns.CommandPattern;

// command
interface Command {
    void execute();
}

class TextEditorII{

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
class BoldCommand implements Command {
    private TextEditorII textEditorII;
    public BoldCommand(TextEditorII textEditorII){
        this.textEditorII = textEditorII;
    }

    @Override
    public void execute() {
        textEditorII.boldText();
    }
}
class ItalicCommand implements Command {
    private TextEditorII textEditorII;
    public ItalicCommand(TextEditorII textEditorII){
        this.textEditorII = textEditorII;
    }

    @Override
    public void execute() {
        this.textEditorII.italicizeText();
    }
}
class UnderlineCommand implements Command {
    private TextEditorII textEditorII;
    public UnderlineCommand(TextEditorII textEditorII){
        this.textEditorII = textEditorII;
    }

    @Override
    public void execute() {
        this.textEditorII.underlineText();
    }
}

class Button{
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void click(){
        command.execute();
    }
}

public class WithCommandPattern {
    public static void main(String[] args) {
        TextEditorII editorII=new TextEditorII();
        //Button
        // Decoupling -> One button can do many types of actions, decoupled from the text editor!
        Button button = new Button();
        button.setCommand(new BoldCommand(editorII));
        button.setCommand(new UnderlineCommand(editorII));
        button.click();
    }
}
