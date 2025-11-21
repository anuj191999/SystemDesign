package DesignPattern.CreationalPatterns.SingletonPatterns;

public class AppSettings {

    private static AppSettings instance;

    private String databaseUrl;
    private String apiKey;

    private AppSettings() {
        databaseUrl = "jdbc:mysql://localhost:3306/";
        apiKey="12345-ABCDE";
    }
    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
