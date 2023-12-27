package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;



public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void Testcase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");

        Thread.sleep(2000);

        String currenturl = driver.getCurrentUrl();

        if (currenturl.contains("makemytrip")) {
            System.out.println("URL contains makemytrip");
        } else {
            System.out.println("URL does not contain makemytrip");
        }

        System.out.println("end Test case: testCase01");
    }



    public void TestCase02() throws InterruptedException {
        System.out.println("Start Test case: testcase02");
        driver.get("https://www.makemytrip.com/");


        //from location
        WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
        from.click();
        Thread.sleep(5000);
        WebElement searchfrom = driver.findElement(By.xpath("//input[@placeholder='From']"));
        searchfrom.sendKeys("blr");
        Thread.sleep(5000);
        WebElement firstfrom = driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText'][1]"));
        firstfrom.click();



        //to location
        WebElement to=driver.findElement(By.xpath("//input[@id='toCity']"));
        to.click();
        Thread.sleep(5000);
        WebElement searchTo=driver.findElement(By.xpath("//input[@placeholder='To']"));
        searchTo.sendKeys("DEL");
        Thread.sleep(5000);
        WebElement firstTo=driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0'][1]"));
        firstTo.click();


        //departure date and date of travel

        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            System.out.println("Testcase02 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
        }

        //click on search btn
        WebElement searchbtn = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
        Thread.sleep(2000);
        searchbtn.click();

        //close ad
        driver.findElement(By.xpath("//span[@class='bgProperties  overlayCrossIcon icon20']")).click();

        //store the flight price in adult
        String flightprice;
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> flightpriceelem = (List<WebElement>) driver.findElements
                (By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        flightprice = flightpriceelem.get(0).getText();

        //Assert that price is not empty
        assert !flightprice.isEmpty();

        System.out.println("end Test case: testCase02");

    }

    public void TestCase03() throws InterruptedException{

        System.out.println("Start Test case: testcase03");
        driver.get("https://www.makemytrip.com/");

        //change to train
        WebElement train = driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chTrains']"));
        train.click();

        //from location
        WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
        from.click();
        Thread.sleep(5000);
        WebElement searchfrom = driver.findElement(By.xpath("//input[@placeholder='From']"));
        searchfrom.sendKeys("ypr");
        Thread.sleep(5000);
        WebElement firstfrom = driver.findElement(By.xpath("//span[@class='sr_city blackText'][1]"));
        firstfrom.click();


        //to location
        WebElement toTrainLocation=driver.findElement(By.xpath("//input[@id='toCity']"));

        Thread.sleep(5000);
        WebElement searchToTrainLocation=driver.findElement(By.xpath("//input[@placeholder='To']"));
        searchToTrainLocation.sendKeys("ndls");
        Thread.sleep(5000);
        WebElement firstToTrainResult=driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0'][1]"));
        firstToTrainResult.click();



        //departure date and date of travel

        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            System.out.println("Testcase03 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
        }


        //for 3ac class
        WebElement dropDownElement=driver.findElement(By.xpath("//div[@data-cy='classValue']"));

        Thread.sleep(2000);
        WebElement thirdac = driver.findElement(By.xpath("//li[@data-cy='3A']"));
        thirdac.click();
        Thread.sleep(2000);

        //click on the search btn
        WebElement searchbtn = driver.findElement(By.xpath("//a[@data-cy='submit']"));
        searchbtn.click();

        // Store the train price for 3AC.
        String trainprice ;
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> trainpriceelem = driver.findElements(By.xpath("//div[@id='train_options_20-01-2024_0']"));
        trainprice = trainpriceelem.get(0).getText();

        assert !trainprice.isEmpty();

        System.out.println("end Test case: testCase03");



    }


    public void TestCase04() throws InterruptedException {
        System.out.println("Start Test case: testcase04");
        driver.get("https://www.makemytrip.com/");

        //change flight to bus
        WebElement selectbus = driver.findElement(By.xpath("//span[text()='Buses']"));
        selectbus.click();


        //from bus
        WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
        from.click();

        WebElement fromcity = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromcity.sendKeys("bangl");
        Thread.sleep(3000);
        WebElement fromci = driver.findElement(By.xpath("//span[@class='sr_city blackText']"));
        fromci.click();


        //to bus
        WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));

        WebElement tocity = driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input react-autosuggest__input--open')]"));
        tocity.sendKeys("del");
        Thread.sleep(3000);
        WebElement toci = driver.findElement(By.xpath("//p[@class='searchedResult font14 darkText'][1]"));
        toci.click();

        // select the date
        String date = "January 2024";

        while(driver.findElement(By.xpath("//div[@role='heading']//div[1]")).isDisplayed()){

            System.out.println("Testcase04 : " + driver.findElement(By.xpath("//div[@role='heading']//div[1]")));
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            String currMonth =driver.findElement(By.xpath("//div[@role='heading']//div[1]")).getText();
            if(date.equalsIgnoreCase(currMonth))
            {
                driver.findElement(By.xpath("//div[@aria-label='Sat Jan 20 2024']")).click();
                break;
            }
        }




        //click on search btn
        WebElement searchbtn = driver.findElement(By.xpath("//button[@data-cy='submit']"));
        searchbtn.click();


        //verify no busses found
        WebElement noBusesElement = driver.findElement(By.xpath("//span[@class='error-title']"));
        String displayedText = noBusesElement.getText();
        if(displayedText.contains("No buses found")){
            System.out.println(displayedText);
        }else{
            System.out.println("bus is shown");
        }

        System.out.println("end Test case: testCase04");








    }
}
