package observable.wetherStation;

public interface Observer {

     void update(double updatedTemperature,double updatedHumidity);
     void register(Subject subject);
     void unregister(Subject subject);
}
