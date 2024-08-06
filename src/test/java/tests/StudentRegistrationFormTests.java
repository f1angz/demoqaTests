package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Percentage;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;

import java.io.File;
import java.sql.Ref;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests extends TestBase {

    private final File picture = new File("src/test/resources/images.png");

    /**
     * Expected values
     */
    private final String firstName = "Semyon";
    private final String lastName = "Semagin";
    private final String email = "semagil@mail.ru";
    private final String phone = "8987065049";
    private final String gender = "Male";
    private final String dateOfBirth = "16 November,2003";
    private final String address = "Some Address1";
    private final String file = "images.png";
    private final List<String> subject = List.of("English");
    private final String verify_subject = "English";
    private final String state = "NCR";
    private final String city = "Delhi";
    private final String day = "16";
    private final String month = "November";
    private final String year = "2003";
    private final String hobby = "Sports";


    @Test
    @Owner("Semyon Semagin")
    @DisplayName("Проверка заголовка страницы")
    @Story("Успешный ввод данных")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Заполнение формы Student Registration")
    void checkTitleTest() {
        RegistrationFormPage registrationFormPage = RegistrationFormPage.openPage();

        String expectedTitle = "Student Registration Form";
        String actualTitle = registrationFormPage.getTitle();
        step("Заголовок страницы содержит " + "'" + expectedTitle + "'", () -> {
            Assertions.assertEquals(actualTitle, expectedTitle);
        });
    }

    @Test
    @Owner("Semyon Semagin")
    @DisplayName("Успешный ввод всех данных в поля")
    @Story("Успешный ввод данных")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Feature("Заполнение формы Student Registration")
    void fillingRegistrationForm() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        RegistrationFormPage registrationFormPage = RegistrationFormPage.openPage();

        step("Заполнение полей", () -> {
            registrationFormPage.
                    setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setDateOfBirth(day, month, year)
                    .setSubject(subject)
                    .setHobbies(hobby)
                    .setPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });


        step("Проверка результатов", () -> {
            registrationFormPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phone)
                    .verifyResult("Date of Birth", dateOfBirth)
                    .verifyResult("Subjects", verify_subject)
                    .verifyResult("Hobbies", hobby)
                    .verifyResult("Picture", file)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        });
    }
}
