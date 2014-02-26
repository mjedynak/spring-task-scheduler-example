package pl.mjedynak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledTask {

    @Autowired private TimePrinter timePrinter;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        timePrinter.reportCurrentTime();
    }

}
