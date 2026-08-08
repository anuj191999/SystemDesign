package question.NotificationSender.channels;

import question.NotificationSender.model.Notification;
import question.NotificationSender.model.User;

public class SMSChannle implements NotificationChannle{
    @Override
    public boolean send(User user, Notification event) {
        try{
            System.out.println("Sending SMS to "+user.getMobNo()+" : message :: "+event.getMessage());
            return true;
        }catch (Exception e){
            System.out.println("Exception Occurred Exception : "+e.getMessage());
        }
        return false;
    }
}
