package annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iba.kozlov.web.books.BookController;
import com.iba.kozlov.web.books.BookDataFacade;

public class BasicAnnotationTest {
	private static Integer totalCost ;
	private static Integer totalCostTest ;

	@BeforeClass
    public static void runOnceBeforeClass() {
		 totalCostTest = new BookDataFacade(new BookController()).totalCost();
		 totalCost = 248979;
		// totalCostTest = null;
	}

   
    @AfterClass
    public static void runOnceAfterClass() {
       
    }

    @Test
    public void test_method_1() {	
    	assertNotNull(totalCostTest);
    	assertEquals(totalCost,totalCostTest);
    }


}
