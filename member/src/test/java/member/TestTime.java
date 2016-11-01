package member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import org.junit.Test;

public class TestTime {
	
	@Test
	public void TestTimes() throws ParseException {
		TimeZone default1 = TimeZone.getDefault();
		int rawOffset = default1.getRawOffset();
		int hour=-rawOffset/3600000;
		
		
		
		
		String min_string="2016-10-31 07:01";
		String max_string="2016-11-02 00:00";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
		Date min_date = sdf1.parse(min_string);
		Date max_date = sdf1.parse(max_string);
		Calendar start_date = Calendar.getInstance();
		start_date.setTime(min_date);
		start_date.add(Calendar.HOUR,hour);
		Calendar end_date = Calendar.getInstance();
		end_date.setTime(max_date);
		end_date.add(Calendar.HOUR, hour);
		Set<String> set=new HashSet<String>();
		set.add("biz-"+sdf2.format(end_date.getTime()));
		
		while(end_date.after(start_date)){
			set.add("biz-"+sdf2.format(start_date.getTime()));
			start_date.add(Calendar.DATE, 1);
		}
		String[] strs=new String[set.size()];
		set.toArray(strs);
		for (String string : strs) {
			System.out.println(string);
		}
		 
		 
		
		
		
	}

}
