import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    void successfulSearchTest() {
        openChromeByURL("https://google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    public void openChromeByURL(String URL) {
        open(URL);
        // Press the 'Accept all' button if such pop-up displayed
        String button = "//button//div[contains(text(), 'Принять все')]";
        if ($x(button).isDisplayed()) {
            $x(button).click();
        }
    }

}