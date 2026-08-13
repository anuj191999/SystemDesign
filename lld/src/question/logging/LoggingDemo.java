package question.logging;

import question.logging.appender.Appender;
import question.logging.appender.ConsoleAppender;
import question.logging.appender.FileAppender;
import question.logging.config.LoggerConfig;
import question.logging.core.Logger;
import question.logging.core.LoggerFactory;
import question.logging.enums.LogLevel;
import question.logging.formater.DefaultLogFormatter;

import java.util.ArrayList;
import java.util.List;

public class LoggingDemo {
    public static void main(String[] args) {
        List<Appender> appenderList=new ArrayList<>();
        appenderList.add(new ConsoleAppender());
        appenderList.add(new FileAppender());
        LoggerFactory.initialize(new LoggerConfig(LogLevel.INFO,appenderList,new DefaultLogFormatter()));

        Logger log=LoggerFactory.getLogger(LoggingDemo.class);

        log.info("My Custom log");

    }
}
