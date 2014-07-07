package pl.mjedynak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.await;
import static java.lang.Thread.getAllStackTraces;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ScheduledTaskIntegrationTest {

    @Test
    public void shouldInvokeTask() {
        Callable<Boolean> threadWithNameExists = () -> getAllStackTraces().keySet().stream().anyMatch(t -> t.getName().equals(ScheduledTask.THREAD_NAME));
        await().until(threadWithNameExists, is(true));
    }

}
