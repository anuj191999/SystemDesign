package DesignPattern.CreationalPatterns.AbtractPatterns.Solution;

interface Button{
    void render();
}

interface ScrollBar{
    void render();
}

class WindowButton implements Button{

    @Override
    public void render() {
        System.out.println("Rendering Window Button");
    }
}
class WindowScrollBar implements ScrollBar{

    @Override
    public void render() {
        System.out.println("Rendering Window ScrollBar");
    }
}

class MacOSButton implements Button{

    @Override
    public void render() {
        System.out.println("Rendering MacOS Button");
    }
}

class MacOSScrollBar implements ScrollBar{

    @Override
    public void render() {
        System.out.println("Rendering MacOS ScrollBar");
    }
}

interface UIFactory{
    Button createButton();
    ScrollBar createScrollBar();
}

class WindowUIFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowScrollBar();
    }
}

class MacOSUIFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacOSScrollBar();
    }
}

public class Applications {
     private Button button;
     private ScrollBar scrollbar;

    Applications(UIFactory uiFactory){
        button=uiFactory.createButton();
        scrollbar=uiFactory.createScrollBar();
    }

    public static void main(String[] args) {

        Applications app=new Applications(new WindowUIFactory());
        app.button.render();
        app.scrollbar.render();
    }
}
