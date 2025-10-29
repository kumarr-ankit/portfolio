package ankitkumar.TodoTracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class DateTest {

    @Test
    public void checkDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, u ");
        String s =  date.format(formatter);

        System.out.println(date);
        System.out.println(s);
    }
}
