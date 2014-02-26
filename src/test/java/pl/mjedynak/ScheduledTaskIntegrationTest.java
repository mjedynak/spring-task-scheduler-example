package pl.mjedynak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class)
public class ScheduledTaskIntegrationTest {

    @ReplaceWithMock @Autowired private TimePrinter timePrinter;

    @Test
    public void shouldInvokeTask() {
        verify(timePrinter).printCurrentTime();
    }

}
