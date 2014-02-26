package pl.mjedynak;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePrinter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final Logger LOGGER = LoggerFactory.getLogger(TimePrinter.class.getName());

    public void reportCurrentTime() {
        LOGGER.info("The time is now " + DATE_FORMAT.format(new Date()));
    }

}
