package experiments;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
			Date d = new Date();
			String dt = d.toString();
			System.out.println(dt);
			LocalDate localDate = LocalDate.now();
			String date = localDate.toString();
			System.out.println(date);
			LocalDate addedDate = localDate.plusDays(10);
			LocalDate red = localDate.plusDays(60);
			System.out.println(red);
			System.out.println(addedDate);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			String formatDate = sdf.format(d);
			System.out.println(formatDate);
			SimpleDateFormat nsdf = new SimpleDateFormat("dd-MMM-yy");
			String formattedDate = nsdf.format(d);
			System.out.println(formattedDate);
			String lowerCase = formattedDate.toLowerCase();
			System.out.println(lowerCase);
	}
}
