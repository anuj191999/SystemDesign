package DesignPattern.CreationalPatterns.SingletonPatterns;

public class SingletonPattern {
    public static void main(String[] args) {
        AppSettings appSettings=AppSettings.getInstance();
        AppSettings appSettingsCopy=AppSettings.getInstance();

        System.out.println(appSettingsCopy.getApiKey());
        System.out.println(appSettings.getApiKey());
        System.out.println(appSettings==appSettingsCopy);
    }
}
