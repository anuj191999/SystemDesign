package question.logging.core;

import question.logging.appender.Appender;
import question.logging.config.LoggerConfig;
import question.logging.enums.LogLevel;
import question.logging.model.LogEvent;

public class Logger {
    private String loggerName;
    private LoggerConfig config;

    public Logger(String loggerName,LoggerConfig config){
        this.loggerName=loggerName;
        this.config=config;
    }

    public void debug(String msg){
        log(LogLevel.DEBUG,msg);
    }
    public void info(String msg){
        log(LogLevel.INFO,msg);
    }
    public void warn(String msg){
        log(LogLevel.WARNING,msg);
    }
    public void error(String msg){
        log(LogLevel.ERROR,msg);
    }

    private void log(LogLevel level, String message){
        if(!level.isEnabled(config.getLevel())){
            return;
        }

        LogEvent event=new LogEvent(message,level,loggerName);

        for (Appender appender:config.getAppenderList()){
            appender.append(event,config.getFormatter());
        }
    }
}
