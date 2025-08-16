package observable.wetherStation;

public class DisplayElement implements Observer {
    private double temperature;
    private double humidity;
    @Override
    public void update(double updatedTemperature, double updatedHumidity) {
        this.temperature = updatedTemperature;
        this.humidity = updatedHumidity;
        display();
    }

    private void display() {
        System.out.println("Temperature: " + temperature);
    }

    @Override
    public void register(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void unregister(Subject subject) {
        subject.removeObserver(this);
    }
}
