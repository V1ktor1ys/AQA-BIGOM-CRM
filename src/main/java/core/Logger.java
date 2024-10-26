package core;

import java.util.logging.*;

public class Logger {

    /**
     * Logger method
     */
    public static void getLog(Level level, String message) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.class.getName());
        logger.setLevel(level);
        logger.info(message);
    }
}
