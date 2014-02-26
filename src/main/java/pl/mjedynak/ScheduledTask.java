package pl.mjedynak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTask {

    @Autowired private TimePrinter timePrinter;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        timePrinter.printCurrentTime();
    }

}
