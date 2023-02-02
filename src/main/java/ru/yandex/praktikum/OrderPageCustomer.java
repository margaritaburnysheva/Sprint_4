package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageCustomer {
    private WebDriver driver;
    //локатор для поля "Имя"
    private By firstNameForm= By.cssSelector("input[placeholder='* Имя']");
    //локатор для поля "Фамилия"
    private By lastNameForm= By.cssSelector("input[placeholder='* Фамилия']");
    //локатор для поля "Адрес: куда привезти заказ"
    private By addressOrderForm=By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля "Станция метро"
    private By subwayStationForm=By.cssSelector("input[placeholder='* Станция метро']");
    //локатор для выпадающего списка "Станция метро"
    private By subwayStationList=By.className("select-search__select");
    //локатор для поля "Телефон: на него позвонит курьер"
    private By phoneNumberForm=By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки "Далее"
    private By buttonNext= By.xpath(".//button[text()='Далее']");
    //локатор для заголовка "Про аренду" на второй странице создания заказа
    private By headerOrderRentPage=By.xpath(".//div[text()='Про аренду']");
    public OrderPageCustomer(WebDriver driver) {
        this.driver = driver;
    }
    public OrderPageCustomer inputFirstName(String firstName){
        driver.findElement(firstNameForm).sendKeys(firstName);
        return this;
    }
    public OrderPageCustomer inputLastName(String lastName){
        driver.findElement(lastNameForm).sendKeys(lastName);
        return this;
    }
    public OrderPageCustomer inputAddress(String address){
        driver.findElement(addressOrderForm).sendKeys(address);
        return this;
    }
    public void chooseSubwayStation(String subwayStation) {
        driver.findElement(subwayStationForm).click();
        driver.findElement(subwayStationForm).sendKeys(subwayStation);
        driver.findElement(subwayStationList).click();
    }
    public OrderPageCustomer inputPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberForm).sendKeys(phoneNumber);
        return this;
    }
    public void clickNext() {
        driver.findElement(buttonNext).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderRentPage));
    }
}
