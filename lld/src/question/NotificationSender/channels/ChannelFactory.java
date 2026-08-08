package question.NotificationSender.channels;

import question.NotificationSender.enums.ChannleType;

import java.util.HashMap;
import java.util.Map;

public class ChannelFactory {
    private static final Map<ChannleType,NotificationChannle> channels=new HashMap<>();
    static {
        channels.put(ChannleType.EMAIL,new EmailChannle());
        channels.put(ChannleType.SMS,new SMSChannle());
        channels.put(ChannleType.WHATSAPP,new WhatsAPPChannle());
    }
    public static NotificationChannle getChannle(ChannleType type){
        return channels.getOrDefault(type,null);
    }
}
