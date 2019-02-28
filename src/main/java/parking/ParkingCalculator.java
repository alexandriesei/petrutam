package parking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParkingCalculator {
String price="$ 2.00";

    WebElement element;
    WebDriver webDriver;
    By typeLocator = By.id("Lot");
    By selectTyleLocator = By.xpath("//*[@id=\"Lot\"]/option[3]");
    By entryTimeLocator = By.xpath("//*[@id=\"EntryTime\"]");
    By entryDateLocator = By.id("EntryDate");
    By leavingTimeLocator = By.xpath("//*[@id=\"ExitTime\"]");
    By leavingDateLocator = By.id("ExitDate");
    By calculateButtonLocator = By.xpath("/html/body/form/input[2]");

    List<WebElement> products = webDriver.findElements(typeLocator);



    public ParkingCalculator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void chooseALot() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(typeLocator).click();
        webDriver.findElement(selectTyleLocator).click();

    }

    public void entryTime(String time) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(entryTimeLocator).click();
        webDriver.findElement(entryTimeLocator).clear();
        webDriver.findElement(entryTimeLocator).sendKeys(time);


    }

    public void entryDate(String date) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(entryDateLocator).click();
        webDriver.findElement(entryDateLocator).clear();
        webDriver.findElement(entryDateLocator).sendKeys(date);
    }

    public void leavingDate(String date) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(leavingDateLocator).click();
        webDriver.findElement(leavingDateLocator).clear();
        webDriver.findElement(leavingDateLocator).sendKeys(date);
    }



    public void leavingTime(String time) {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(leavingTimeLocator).click();
        webDriver.findElement(leavingTimeLocator).clear();
        webDriver.findElement(leavingTimeLocator).sendKeys(time);
    }

    public void clickCalculate(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(calculateButtonLocator).click();
    }


 public void calculatePriceforOanHour(String time, String timeL, String date, String dateL,String price){
        ParkingCalculator parkingCalculator;
        chooseALot();
        entryTime(time);
        entryDate(date);
        leavingTime(timeL);
        leavingDate(dateL);
        clickCalculate();
     Assert.assertEquals(webDriver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b")).getText(),price);

    }






}
