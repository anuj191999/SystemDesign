package DesignPattern.CreationalPatterns.AbtractPatterns.Problem;
// window UI Component
class WindowButton{
    public void render(){
        System.out.println("Rendering Windows button");
    }
}

class windowScrollBar{
    public void render(){
        System.out.println("Rendering Windows ScrollBar");
    }
}

// Mac UI Component

class MacOSButton{
    public void render(){
        System.out.println("Rendering MacOS Button");
    }
}

class MacOSScrollBar {
    public void render(){
        System.out.println("Rendering MacOS ScrollBar");
    }
}

public class Applications {
    public static void main(String[] args) {
        windowScrollBar scrollBar = new windowScrollBar();
        MacOSButton macOSButton = new MacOSButton();
        macOSButton.render();
        scrollBar.render();

    }
}
