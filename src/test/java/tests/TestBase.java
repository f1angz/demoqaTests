package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

/**
 * Base class for all tests
 */

public abstract class TestBase {

    private final static String BASE_URL = "https://demoqa.com/";
    private final static String BROWSER = "chrome";
    private final static String BROWSER_SIZE = "1920x1080";

    /**
     * Browser configuration
     */
    @BeforeAll
    public static void init() {
        Configuration.browser = BROWSER;
        Configuration.headless = false;
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.baseUrl = BASE_URL;
    }
}
