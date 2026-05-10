package LoadBalancer.Servers;

public class Instance5 implements Server{

    @Override
    public void featchData() {
        System.out.println("Instance-5 Invoked :: Fetching data from Instance5");
    }
}
