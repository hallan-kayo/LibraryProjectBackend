package com.project.library.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public Date formatToDate(String data) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			date = format.parse(data);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
