import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardDeliveryTest {
    public LocalDate today = LocalDate.now();
    public String setDataDefault = today.plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
}
