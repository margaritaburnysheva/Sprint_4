package ScooterTests;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import ru.yandex.praktikum.MainPage;

@RunWith(Parameterized.class)
public class CheckAnswersTests{
    private WebDriver driver;
    private static String expectedAnswer;
    private static By buttonQuestion;
    private static By factAnswer;

    public CheckAnswersTests(By buttonQuestion,By factAnswer,String expectedAnswer){
        this.buttonQuestion=buttonQuestion;
        this.factAnswer=factAnswer;
        this.expectedAnswer=expectedAnswer;
    }
    @Parameterized.Parameters
        public static Object[][] testCheckAnswer(){
            return new Object[][]{
                    {MainPage.buttonQuestionOne,MainPage.answerOne,MainPage.expectedAnswerOne},
                    {MainPage.buttonQuestionTwo,MainPage.answerTwo,MainPage.expectedAnswerTwo},
                    {MainPage.buttonQuestionThree,MainPage.answerThree,MainPage.expectedAnswerThree},
                    {MainPage.buttonQuestionFour,MainPage.answerFour,MainPage.expectedAnswerFour},
                    {MainPage.buttonQuestionFive,MainPage.answerFive,MainPage.expectedAnswerFive},
                    {MainPage.buttonQuestionSix,MainPage.answerSix,MainPage.expectedAnswerSix},
                    {MainPage.buttonQuestionSeven,MainPage.answerSeven,MainPage.expectedAnswerSeven},
                    {MainPage.buttonQuestionEight,MainPage.answerEight,MainPage.expectedAnswerEight},
            };
        }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkAnswer(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        String result=mainPage.getTextAnswer(buttonQuestion, factAnswer);
        assertEquals("Текст ответа не соответствует ожидаемому", expectedAnswer, result);
    }
    @After
    public void cleanUp() {
        driver.quit();
    }
    }
