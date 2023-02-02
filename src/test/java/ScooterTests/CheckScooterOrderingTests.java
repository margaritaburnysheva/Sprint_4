package ScooterTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.OrderPageCustomer;
import ru.yandex.praktikum.OrderRentPage;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CheckScooterOrderingTests {
    private WebDriver driver;
    private String firstName;
    private String lastName;
    private String address;
    private String subwayStation;
    private String phoneNumber;
    private String rentDate;
    private String commentText;
    public boolean isOrderFinal;

    public CheckScooterOrderingTests(String firstName,String lastName,String address,String subwayStation,String phoneNumber,String rentDate,String commentText){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.subwayStation=subwayStation;
        this.phoneNumber=phoneNumber;
        this.rentDate=rentDate;
        this.commentText=commentText;
    }
    @Parameterized.Parameters
    public static Object[][] testCustomerData(){
        return new Object[][]{
                {"Иван","Иванов","Москва, проспект Вернадского, 8","Университет","+79999999991","31.01.2023","Очень жду!"},
                {"Марина","Маринина","Москва","Охотный Ряд","+7999999992","30.01.2023","Ура"},
        };
    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkScooterOrderingTestButtonUp() {
        MainPage mainPage = new MainPage(driver);
        OrderPageCustomer orderPageCustomer = new OrderPageCustomer(driver);
        OrderRentPage orderRentPage = new OrderRentPage(driver);
        mainPage.openMainPage();
        mainPage.openOrderPageCustomerUp();
        orderPageCustomer.inputFirstName(firstName).inputLastName(lastName).inputAddress(address);
        orderPageCustomer.chooseSubwayStation(subwayStation);
        orderPageCustomer.inputPhoneNumber(phoneNumber);
        orderPageCustomer.clickNext();
        orderRentPage.inputOrderRentDate(rentDate);
        orderRentPage.checkScooterColor();
        orderRentPage.clickRentTimeForm();
        orderRentPage.inputCommentForCourier(commentText);
        orderRentPage.checkOrderVerification();
        isOrderFinal = orderRentPage.isOrderFinal();
        assertTrue("Произошла ошибка при оформлении заказа", isOrderFinal);
    }
    @Test
    public void checkScooterOrderingTestWithButtonDown() {
        MainPage mainPage = new MainPage(driver);
        OrderPageCustomer orderPageCustomer = new OrderPageCustomer(driver);
        OrderRentPage orderRentPage = new OrderRentPage(driver);
        mainPage.openMainPage();
        mainPage.openOrderPageCustomerDown();
        orderPageCustomer.inputFirstName(firstName).inputLastName(lastName).inputAddress(address);
        orderPageCustomer.chooseSubwayStation(subwayStation);
        orderPageCustomer.inputPhoneNumber(phoneNumber);
        orderPageCustomer.clickNext();
        orderRentPage.inputOrderRentDate(rentDate);
        orderRentPage.checkScooterColor();
        orderRentPage.clickRentTimeForm();
        orderRentPage.inputCommentForCourier(commentText);
        orderRentPage.checkOrderVerification();
        isOrderFinal = orderRentPage.isOrderFinal();
        assertTrue("Произошла ошибка при оформлении заказа", isOrderFinal);
    }
        @After
        public void cleanUp() {
            driver.quit();
        }
}
