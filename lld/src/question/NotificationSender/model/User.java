package question.NotificationSender.model;

import question.NotificationSender.enums.ChannleType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private String userId;
    private String email;
    private String mobNo;
    Set<ChannleType> preference;

    public User(String mobNo, String email) {
        userId= UUID.randomUUID().toString();
        this.mobNo = mobNo;
        this.email = email;
        this.preference= new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public Set<ChannleType> getPreference() {
        return preference;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public void addPreference(ChannleType preference) {
        this.preference.add(preference);
    }
    public void removePreference(ChannleType preference) {
        this.preference.remove(preference);
    }
}
