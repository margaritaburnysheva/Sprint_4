package ScooterTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import ru.yandex.praktikum.MainPage;

public class CheckAnswersTests {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkFirstAnswer(){
        String expectedTextAnswerOne="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionOne, mainPage.answerOne);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkSecondAnswer(){
        String expectedTextAnswerOne="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionTwo, mainPage.answerTwo);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkThirdAnswer(){
        String expectedTextAnswerOne="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionThree, mainPage.answerThree);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkFourthAnswer(){
        String expectedTextAnswerOne="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionFour, mainPage.answerFour);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkFifthAnswer(){
        String expectedTextAnswerOne="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionFive, mainPage.answerFive);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkSixthAnswer(){
        String expectedTextAnswerOne="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionSix, mainPage.answerSix);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkSeventhAnswer(){
        String expectedTextAnswerOne="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionSeven, mainPage.answerSeven);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @Test
    public void checkEighthAnswer(){
        String expectedTextAnswerOne="Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(mainPage.buttonQuestionEight, mainPage.answerEight);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedTextAnswerOne, result);
    }
    @After
    public void cleanUp() {
        driver.quit();
    }
}
