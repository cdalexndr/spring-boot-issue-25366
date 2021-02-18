package example;


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
class SomeServiceTest2 extends AbstractTestNGSpringContextTests {

    @SpyBean
    SomeService someService;

    @Test(dependsOnGroups = "1")
    public void test2() {
        verify(someService, times(0)).method();
        someService.method(); //no throw stub
    }
}