package LoadBalancer.Servers;

public class Instance4 implements Server{

    @Override
    public void featchData() {
        System.out.println("Instance-4 Invoked :: Fetching data from Instance4");
    }
}
