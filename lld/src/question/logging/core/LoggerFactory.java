package question.logging.core;

import question.logging.config.LoggerConfig;

public class LoggerFactory {
    private static LoggerConfig globalConfig;

    public  static void initialize(LoggerConfig config){
        globalConfig=config;
    }
    public static Logger getLogger(Class<?> clazz){
        return new Logger(clazz.getName(),globalConfig);
    }
}
