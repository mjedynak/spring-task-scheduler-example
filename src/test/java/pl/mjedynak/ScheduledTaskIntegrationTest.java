package pl.mjedynak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ScheduledTaskIntegrationTest {

    @Test
    public void shouldInvokeTask() {
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        long count = threads.stream().filter(t -> t.getName().equals(ScheduledTask.THREAD_NAME)).count();

        assertThat(count, is(1L));
    }

}
