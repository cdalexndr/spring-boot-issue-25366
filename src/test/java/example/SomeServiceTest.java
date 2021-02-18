package example;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@TestExecutionListeners(MockitoTestExecutionListener.class)
class SomeServiceTest extends AbstractTestNGSpringContextTests {

    @SpyBean
    SomeService someService;

    @Test(groups = "1")
    public void test() {
        doThrow(new RuntimeException("test case")).when(someService).method();
        boolean thrown = false;
        try {
            someService.method();
        } catch (Exception ex) {
            thrown = true;
        }
        assert thrown;
        verify(someService, times(1)).method();
    }

}