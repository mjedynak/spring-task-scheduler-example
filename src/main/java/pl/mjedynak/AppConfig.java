package pl.mjedynak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("pl.mjedynak")
public class AppConfig {

    @Bean
    public ScheduledTask scheduledTask() {
        return new ScheduledTask();
    }

    @Bean
    public TimePrinter timePrinter() {
        return new TimePrinter();
    }
}
