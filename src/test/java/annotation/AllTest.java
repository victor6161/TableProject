package annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicAnnotationTest.class, Test2.class })
public class AllTest {
    @Test
    public void test_method_1() {
    	   System.out.println("all_test");
    }
}
