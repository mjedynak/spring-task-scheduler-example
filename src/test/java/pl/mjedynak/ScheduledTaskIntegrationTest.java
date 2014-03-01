package pl.mjedynak;

import com.google.common.base.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static com.google.common.collect.Iterables.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ScheduledTaskIntegrationTest {

    @Test
    public void shouldInvokeTask() {
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        any(threads, new HasNameEqualTo(ScheduledTask.THREAD_NAME));
    }

    private static class HasNameEqualTo implements Predicate<Thread> {

        private final String threadName;

        public HasNameEqualTo(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public boolean apply(Thread thread) {
            return thread.getName().equals(threadName);
        }
    }
}
