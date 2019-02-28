import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import parking.ParkingCalculator;

public class ParkingTest {

    WebDriver webDriver ;
    ParkingCalculator parking;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }


    @BeforeTest
    public void init() {

        webDriver.get("http://adam.goucher.ca/parkcalc/index.php");
        webDriver.manage().window().maximize();
        parking = new ParkingCalculator(webDriver);
    }
    @DataProvider(name = "information")
    public static Object[][] credentials() {
        return new Object[][] { {  "11:00","2/5/2019","12:00","2/5/2019" }};
    }
    @Test(groups = "pozitiv")
    public void ParkingCalculateTest(String time, String timeL, String date, String dateL,String price) {
        ParkingCalculator parkingCalculator =  new ParkingCalculator(webDriver);
        parkingCalculator.calculatePriceforOanHour(time,timeL,date,dateL,price);
    }

    @AfterSuite
    public void closeWebDriver()
    {
        webDriver.close();
    }

}
