package ankitkumar.TodoTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class TodoTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoTrackerApplication.class, args);
	}

/*	public static class DateClass {
		public static void main(String[] args) {
			System.out.println(System.currentTimeMillis());
		   Date date = new Date();
			System.out.println(date.getHours());
			System.out.println(date.getMinutes());

			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.getCalendarType());
			System.out.println(calendar.getTimeZone().getID());

			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			System.out.println(gregorianCalendar.isLeapYear(gregorianCalendar.getWeekYear()));
			System.out.println(gregorianCalendar.get(Calendar.YEAR));
			System.out.println(gregorianCalendar.getTimeZone());

			LocalDate d = LocalDate.now();
			System.out.println(d);

			LocalTime localTime = LocalTime.now();
			System.out.println(localTime);

			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println(localDateTime);

			DateTimeFormatter df = DateTimeFormatter.ofPattern("E,dd u");
			localDateTime.format(df);
			System.out.println(localDateTime.format(df));
		}
	}  */
}
