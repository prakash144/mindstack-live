/*
    Flowchart/Mind Map:

                    +---------------------+
                    |     Main Method     |
                    +---------------------+
                              |
                              v
                +-----------------------------+
                | Create LogProcessor chain:   |
                | Info -> Error -> Debug       |
                +-----------------------------+
                              |
                              v
                +-----------------------------------+
                | Call log() on LogProcessor chain  |
                +-----------------------------------+
                                 |
                +------------------+----------------+
                |                  |                |
                v                  v                v
              [INFO]              [ERROR]          [DEBUG]
               Log                Log               Log
              (if INFO)           (if ERROR)        (if DEBUG)

    - If a log level matches, log message and stop the chain.
    - If it doesn't match, pass to the next handler in the chain.
*/


public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));

        logProcessor.log(LogProcessor.DEBUG,"Debug Message");
        logProcessor.log(LogProcessor.ERROR,"Error Message");
        logProcessor.log(LogProcessor.INFO,"Info Message");
    }
}