package dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {

	public static void main(String[] args) {
		
		Date now = new Date();
		SimpleDateFormat date = new SimpleDateFormat(); 
		
		System.out.println(date.format(now));
		
		SimpleDateFormat date2 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분");
		System.out.println(date2.format(now));

	}

}
