package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponents {

    public void setDate(String day, String month, String year) {
        String locator = "'react-datepicker__day react-datepicker__day--0" + day + "'";
        $x("//select[@class='react-datepicker__year-select']").selectOption(year);
        $x("//select[@class='react-datepicker__month-select']").selectOption(month);
        $x("//div[contains(@class," + locator + ")]").click();
    }

}
