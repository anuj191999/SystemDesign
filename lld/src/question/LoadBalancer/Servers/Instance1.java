package question.LoadBalancer.Servers;

public class Instance1 implements Server{
    @Override
    public void featchData() {
        System.out.println("Instance-1 Invoked :: Fetching data from Instance1");
    }
}
