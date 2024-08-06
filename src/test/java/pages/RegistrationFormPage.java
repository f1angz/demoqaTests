package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultsModal;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private static final String URL = "automation-practice-form";
    private CalendarComponents calendarComponents = new CalendarComponents();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailInput =  $x("//input[@id='userEmail']"),
            genderInput = $x("//div[@id='genterWrapper']"),
            phoneInput = $x("//input[@id='userNumber']"),
            subjectsInput = $x("//input[@id='subjectsInput']"),
            hobbiesInput = $x("//div[@id='hobbiesWrapper']"),
            imageInput = $x("//input[@id='uploadPicture']"),
            addressInput = $x("//textarea[@id='currentAddress']"),
            stateInput = $x("//input[@id='react-select-3-input']"),
            cityInput = $x("//input[@id='react-select-4-input']"),
            submitButton = $x("//button[@id='submit']");

    @Step("Открытие страницы")
    public static RegistrationFormPage openPage() {
        open(URL);
        return new RegistrationFormPage();
    }

    @Step("Получение заголовка страницы")
    public String getTitle() {
        return $x("//div[@class='practice-form-wrapper']/h5").text();
    }

    @Step("Установка значения поля First Name")
    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Установка значения поля Last Name")
    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Установка значения поля Email")
    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Установка значения поля Gender")
    public RegistrationFormPage setGender(String gender) {
        genderInput.find(byText(gender)).click();
        return this;
    }

    @Step("Установка значения поля Phone")
    public RegistrationFormPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Установка значения поля Subjects")
    public RegistrationFormPage setSubject(List<String> subjects)  {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    @Step("Установка значения поля Hobbies")
    public RegistrationFormPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузка файла в поле Picture")
    public RegistrationFormPage setPicture(File image) {
        imageInput.uploadFile(image);
        return this;
    }

    @Step("Установка значения поля Address")
    public RegistrationFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    @Step("Установка значения поля State")
    public RegistrationFormPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    @Step("Установка значения поля City")
    public RegistrationFormPage setCity(String city) {
       cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Выбор Date of Birth")
    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $x("//input[@id='dateOfBirthInput']").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    @Step("Нажатие кнопки submit")
    public void clickSubmit() {
        submitButton.click();
    }

    @Step()
    public RegistrationFormPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationFormPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


}
