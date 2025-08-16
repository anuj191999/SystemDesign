package observable.wetherStation;

public class Main {
    public static void main(String[] args) {

        WetherStation station = new WetherStation();
        DisplayElement display1=new DisplayElement();
        DisplayElement display2=new DisplayElement();

        display1.register(station);
        display2.register(station);

        station.setData(0.0,1.3);
    }
}
