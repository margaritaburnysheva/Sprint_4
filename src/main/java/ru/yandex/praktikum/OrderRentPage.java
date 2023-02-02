package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderRentPage {
    private WebDriver driver;
    //локатор для поля "Когда привезти самокат"
    private By orderRentDateForm=By.cssSelector("input[placeholder= '* Когда привезти самокат']");
    //локатор для поля "Срок аренды"
    private By rentTimeForm=By.className("Dropdown-placeholder");
    //локатор для выпадающего списка "Срок аренды"
    private By rentTimeList=By.className("Dropdown-option");
    //локатор для чекбокса "Черный жемчуг" в блоке "Цвет самоката"
    private By blackScooterColor=By.id("black");
    //локатор для чекбокса "Серая безысходность" в блоке "Цвет самоката"
    private By greyScooterColor=By.id("grey");
    //локатор для поля "Комментарий для курьера"
    private By commentForCourier=By.cssSelector("input[placeholder='Комментарий для курьера']");
    //локатор для кнопки "Заказать"
    private By buttonCreateOrder=By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для текста "Ходите оформить заказ?" в окне подтверждения заказа
    private By verificationOrderWindowText=By.xpath(".//div[text()='Хотите оформить заказ?']");
    //локатор для кнопки "Да" в окне подтверждения заказа
    private By buttonYesVerification=By.xpath(".//button[text()='Да']");
    //локатор для текста "Заказ оформлен..." с номером заказа
    private By finalOrderMessage=By.xpath(".//div[text()='Заказ оформлен']");
    public OrderRentPage(WebDriver driver) {
        this.driver = driver;
    }
    public OrderRentPage inputOrderRentDate(String rentDate) {
        driver.findElement(orderRentDateForm).sendKeys(rentDate);
        return this;
    }
    public void clickRentTimeForm() {
        driver.findElement(rentTimeForm).click();
        driver.findElement(rentTimeList).click();
    }
    public void checkScooterColor() {
        driver.findElement(blackScooterColor).click();
        driver.findElement(greyScooterColor).click();
    }
    public OrderRentPage inputCommentForCourier(String commentText) {
        driver.findElement(commentForCourier).sendKeys(commentText);
        return this;
    }
    public void checkOrderVerification() {
        driver.findElement(buttonCreateOrder).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(verificationOrderWindowText));
        driver.findElement(buttonYesVerification).click();
    }
    public boolean isOrderFinal() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(finalOrderMessage));
        boolean isOrderFinal = driver.findElement(finalOrderMessage).isDisplayed();
        return isOrderFinal;
    }
}
