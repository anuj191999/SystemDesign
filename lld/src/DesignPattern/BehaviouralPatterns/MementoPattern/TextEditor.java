package DesignPattern.BehaviouralPatterns.MementoPattern;

/* A text editor where the user can undo changes, such as text addition, deletion,
or formatting. The editor stores snapshots of its state (text content)
after each change, enabling the user to revert to previous states.
 */
public class TextEditor {

    private String content;

    public void write(String text){
        this.content = text;
    }

    public String getContent(){
        return this.content;
    }

    public void restoreContent(EditorMemento previousState){
        this.content = previousState.getContent();
    }

    public EditorMemento getState(){
        return new EditorMemento(this.content);
    }
}
