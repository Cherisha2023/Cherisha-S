//A test class to verify
public class LoggerTest {
    public static void main(String[] args) { //Main entry point of the program
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("First message");
        logger2.log("Second message");
        //Checking if the same Logger instance is used throughout the application
        System.out.println("Same instance: " + (logger1 == logger2));
    }
}

