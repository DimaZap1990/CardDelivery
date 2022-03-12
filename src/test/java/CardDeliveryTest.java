import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.lang.model.element.NestingKind;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    String generateDate (int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    String planingDate= generateDate(4);

    @Test
    public void shouldCardReg() {
        Configuration.holdBrowserOpen=true;
        open("http://localhost:9999/");
        $("[type=\"text\"]").setValue("Ярославль");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planingDate);
        $x("//*[@name=\"name\"]").setValue("Бахмет Олег");
        $("[data-test-id=\"phone\"] input").setValue("+79066869535");
        $("span.checkbox__box").click();
        $x("//*[text()=\"Забронировать\"]").click();
        $("[class=\"notification__title\"]").shouldBe(Condition.visible, Duration.ofSeconds(12));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planingDate));

    }
}