package librarysystem;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Log all levels
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL); // Set the log level to ALL for logging
    }

    // Log an info message
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Log a warning message
    public static void logWarning(String message) {
        logger.warning(message);
    }

    // Log an error message
    public static void logError(String message) {
        logger.severe(message);
    }
}
