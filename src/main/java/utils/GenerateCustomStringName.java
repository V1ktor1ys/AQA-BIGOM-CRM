package utils;

import core.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class GenerateCustomStringName {

    /**
     * Make/Generate String + DateTime
     */
    public static String getStringWithDateTime(String str){
        Logger.getLog(Level.ALL, "Make/Generate String + DateTime");

        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
