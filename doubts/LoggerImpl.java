package doubts;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerImpl implements Logger {

    private String filePath;
    private PrintWriter printWriter;

    private LoggerImpl(){}

    private static LoggerImpl INSTANCE = new LoggerImpl();

    public LoggerImpl getInstance(){
        if(INSTANCE == null){
            synchronized(LoggerImpl.class){
                if(INSTANCE == null){
                    INSTANCE = new LoggerImpl();
                }
            }
        }
        return INSTANCE;
    }

    public void resetInstance(){
        INSTANCE = null;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(INSTANCE == null){
            throw new IllegalStateException();
        }
        printWriter.println();
    }

    @Override
    public void setLogFile(String filePath) {
        this.filePath = filePath;
        try{
         this.printWriter = new PrintWriter(new FileWriter(filePath),true);
        } catch (IOException e){

        }
    }

    @Override
    public String getLogFile() {
        return filePath;
    }

    @Override
    public void flush() {
        printWriter.flush();
    }

    @Override
    public void close() {
        printWriter.close();
    }
}



interface Logger {

    void log(LogLevel level, String message);

    void setLogFile(String filePath);

    String getLogFile();

    // Flush the log entries to the file
    void flush();

    // Close the logger and release any resources
    void close();
}

enum LogLevel{
    DEBUG,ERROR,INFO
}

