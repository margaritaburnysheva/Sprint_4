package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String PAGE_URL="https://qa-scooter.praktikum-services.ru/";
    //ожидаемые ответы на вопросы о важном
    public static String expectedAnswerOne="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static String expectedAnswerTwo="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static String expectedAnswerThree="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static String expectedAnswerFour="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static String expectedAnswerFive="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static String expectedAnswerSix="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static String expectedAnswerSeven="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static String expectedAnswerEight="Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //локаторы для вопросов о важном
    public static By buttonQuestionOne=By.id("accordion__heading-0");
    public static By buttonQuestionTwo=By.id("accordion__heading-1");
    public static By buttonQuestionThree=By.id("accordion__heading-2");
    public static By buttonQuestionFour=By.id("accordion__heading-3");
    public static By buttonQuestionFive=By.id("accordion__heading-4");
    public static By buttonQuestionSix=By.id("accordion__heading-5");
    public static By buttonQuestionSeven=By.id("accordion__heading-6");
    public static By buttonQuestionEight=By.id("accordion__heading-7");
    //локаторы для ответов на вопросы о важном
    public static By answerOne=By.id("accordion__panel-0");
    public static By answerTwo=By.id("accordion__panel-1");
    public static By answerThree=By.id("accordion__panel-2");
    public static By answerFour=By.id("accordion__panel-3");
    public static By answerFive=By.id("accordion__panel-4");
    public static By answerSix=By.id("accordion__panel-5");
    public static By answerSeven=By.id("accordion__panel-6");
    public static By answerEight=By.id("accordion__panel-7");
    //локатор для верхней кнопки "Заказать"
    private By buttonOrderUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    //локатор для нижней кнопки "Заказать"
    private By buttonOrderDown = By.className("Home_FinishButton__1_cWm");
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
    public void openOrderPageCustomerUp(){
        driver.findElement(buttonOrderUp).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderPageCustomer));
    }
    public void openOrderPageCustomerDown(){
        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        element.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerOrderPageCustomer));
    }
}
