import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConcurrentCollectionDemo {

    public static void main(String[] args) throws InterruptedException {

//        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
//
//        Thread producer=new Thread(()->{
//           try{
//               for(int i=0;i<5;i++){
//                   String item="Item"+i;
//                   queue.put(item);
//                   System.out.println("Produced : "+item);
//                   Thread.sleep(1000);
//               }
//           }
//           catch(Exception e){
//               Thread.currentThread().interrupt();
//           }
//        });
//
//        Thread consumer=new Thread(()->{
//            try{
//                for(int i=0;i<5;i++){
//                    String item=queue.take();
//                    System.out.println("Consumed : "+item);
//                    Thread.sleep(1000);
//                }
//            }
//            catch(Exception e){
//                Thread.currentThread().interrupt();
//            }
//        });
//        producer.start();
//        consumer.start();
//
//        producer.join();
//        consumer.join();

        String text = "The year 2024 was amazing, but 2025 is better!";
        Pattern pattern = Pattern.compile("\\d{4}"); // Match any 4-digit number
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
            System.out.println("At position: " + matcher.start() + "-" + matcher.end());
        }
    }
}
