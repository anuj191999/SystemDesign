package LoadBalancer.Servers;

public class Instance3 implements Server{
    @Override
    public void featchData() {
        System.out.println("Instance-3 Invoked :: Fetching data from Instance3");
    }
}
