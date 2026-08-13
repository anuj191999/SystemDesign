package question.logging.appender;

import question.logging.formater.LogFormatter;
import question.logging.model.LogEvent;

public class FileAppender implements Appender{

    @Override
    public void append(LogEvent event, LogFormatter formatter) {
        String formated=formatter.format(event);
        System.out.print("Writing log in file :: ");
        System.out.println(formated);
    }
}
