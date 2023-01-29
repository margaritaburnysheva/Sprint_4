package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String PAGE_URL="https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //локаторы для вопросов о важном
    public By buttonQuestionOne=By.id("accordion__heading-0");
    public By buttonQuestionTwo=By.id("accordion__heading-1");
    public By buttonQuestionThree=By.id("accordion__heading-2");
    public By buttonQuestionFour=By.id("accordion__heading-3");
    public By buttonQuestionFive=By.id("accordion__heading-4");
    public By buttonQuestionSix=By.id("accordion__heading-5");
    public By buttonQuestionSeven=By.id("accordion__heading-6");
    public By buttonQuestionEight=By.id("accordion__heading-7");
    //локаторы для ответов на вопросы о важном
    public By answerOne=By.id("accordion__panel-0");
    public By answerTwo=By.id("accordion__panel-1");
    public By answerThree=By.id("accordion__panel-2");
    public By answerFour=By.id("accordion__panel-3");
    public By answerFive=By.id("accordion__panel-4");
    public By answerSix=By.id("accordion__panel-5");
    public By answerSeven=By.id("accordion__panel-6");
    public By answerEight=By.id("accordion__panel-7");
    //локатор для верхней кнопки "Заказать"
    private By buttonOrderUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    //локатор для нижней кнопки "Заказать"
    private By buttonOrderDown = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //локатор для заголовка "Для кого самокат" на первой странице создания заказа
    private By headerOrderPageCustomer=By.xpath(".//div[text()='Для кого самокат']");

    public void openMainPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonOrderUp));
    };
    public String getTextAnswer(By buttonQuestion, By answer){
        WebElement element = driver.findElement(buttonQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonQuestion));
        element.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).getText();
    };
    public void openOrderPageCustomer(){
        driver.findElement(buttonOrderUp).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderPageCustomer));
    }
}
