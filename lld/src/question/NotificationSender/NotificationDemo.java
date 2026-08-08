package question.NotificationSender;
import question.NotificationSender.enums.ChannleType;
import question.NotificationSender.model.*;

public class NotificationDemo {
    public static void main(String[] args) {
        User user=new User("7070066397","choubeyanujkumar3@gmail.com");
        user.addPreference(ChannleType.EMAIL);
        user.addPreference(ChannleType.SMS);
        user.addPreference(ChannleType.WHATSAPP);

        NotificationService service=new NotificationService();
        service.notifyUser(user,"Your order has been shipped!");

    }
}
