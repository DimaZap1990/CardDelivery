import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import javax.lang.model.element.NestingKind;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    public LocalDate today = LocalDate.now();
    public String setDataDefault = today.plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    @Test
    public void shouldCardReg() {
        open("http://localhost:9999/");
        $("[type=\"text\"]").setValue("Ярославль");
        $("[data-test-id='date'] input").doubleClick().setValue(String.valueOf(setDataDefault));
        $x("//*[@name=\"name\"]").setValue("Бахмет Олег");
        $("[data-test-id=\"phone\"] input").setValue("+79066869535");
        $("span.checkbox__box").click();
        $x("//*[text()=\"Забронировать\"]").click();
        $("[class=\"notification__title\"]").shouldBe(Condition.visible, Duration.ofSeconds(10));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setDataDefault));







    }
}