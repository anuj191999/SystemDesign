package boomyshow;

public class user {
    private String userId;
    private String name;

    public user(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
