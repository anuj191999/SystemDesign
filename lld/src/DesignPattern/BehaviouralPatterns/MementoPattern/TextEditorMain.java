package DesignPattern.BehaviouralPatterns.MementoPattern;

public class TextEditorMain {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CareTaker careTaker = new CareTaker();
        editor.write("Hello Word");
        careTaker.saveState(editor);
        editor.write("Hello Vikas Ji");
        careTaker.saveState(editor);
        careTaker.undo(editor);


        System.out.println(editor.getContent());

    }
}
