import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {


    private final String URL = "automation-practice-form";
    private final File picture = new File("src/test/resources/images.png");

    /**
     Expected values
     */
    private final String firstName = "Semyon";
    private final String lastName = "Semagin";
    private final String email = "semagil@mail.ru";
    private final String phone = "8987065049";
    private final String dateOfBirth = "16 November,2003";
    private final String address = "Some Address1";
    private final String file = "images.png";
    private final String subject = "English";
    private final String state = "NCR";
    private final String city = "Delhi";


    /**
     * Test to check whether the field is filled in correctly
     */
    @Test
    void fillingRegistrationForm() {
        open(URL);

        // Search and fill in all fields
        $x("//input[@id='firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $x("//input[@id='userEmail']").setValue(email);
        $x("//label[@class='custom-control-label']").click();
        $x("//input[@id='userNumber']").setValue(phone);
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__year-select']").selectOptionByValue("2003");
        $x("//select[@class='react-datepicker__month-select']").selectOptionByValue("10");
        $x("//div[@class='react-datepicker__day react-datepicker__day--016 react-datepicker__day--weekend']").click();
        $x("//input[@id='subjectsInput']").setValue("English").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $x("//input[@id='uploadPicture']").uploadFile(picture);
        $x("//textarea[@id='currentAddress']").setValue(address);
        $x("//input[@id='react-select-3-input']").setValue(state).pressEnter();
        $x("//input[@id='react-select-4-input']").setValue(city).pressEnter();
        $x("//button[@id='submit']").click();

        // Examination
        $x("//div[@class='table-responsive']").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(phone),
                text(dateOfBirth),
                text(subject),
                text(file),
                text(address),
                text(state),
                text(city)
        );
    }
}
