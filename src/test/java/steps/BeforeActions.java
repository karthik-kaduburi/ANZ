package steps;



import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class BeforeActions  {

	/**
	 * setup driver instance
	 */
	@Before
    public static void setUp() {
    	System.out.println("Before");
       SeleniumDriver.setUpDriver();
    }
}
