package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Run {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ParseException {
		
		
		SecureRandom random = new SecureRandom();
		PrintWriter writer = new PrintWriter("SequanceOfDates.txt", "UTF-8");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date = dateFormat.parse("2014-01-01");
		c.setTime(date);
		
		
		for(int i=1; i<1001; i++){
			
			
			String randomTest = new BigInteger(130, random).toString(32);
			writer.println("<node id=" + i +">");
			writer.println("<name>"+ randomTest +"</name>");
			writer.println("<date>" + dateFormat.format(c.getTime()) + "</date>");
			writer.println("</node>");
			
			c.add(Calendar.DATE, 1);
		}
		
		
		
		
		writer.close();
		

		
	}

}
