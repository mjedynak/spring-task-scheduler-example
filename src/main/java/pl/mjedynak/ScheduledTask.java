package pl.mjedynak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTask {

    static final String THREAD_NAME = ScheduledTask.class.getName() + "!";
    @Autowired private TimePrinter timePrinter;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Thread.currentThread().setName(THREAD_NAME);
        timePrinter.printCurrentTime();
    }

}
