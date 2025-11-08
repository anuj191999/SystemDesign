package DesignPattern.BehaviouralPatterns.MementoPattern;

import java.util.Stack;

// caretaker class : manages mementos (snapshot's of text editor state)
public class CareTaker {

    private final Stack<EditorMemento> history = new Stack<>();


    public void undo(TextEditor editor){
        if(!history.empty()){
            history.pop();
            editor.restoreContent(history.peek());
        }
    }

    public void saveState(TextEditor editor){
        history.push(editor.getState());
    }
}
