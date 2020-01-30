package com.wildcodeschool.wildcircus.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FormatDate {
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public Date dateAndTimeToFull(String date, String time) {
		String tempDate = date + " " + time;
		Date finalDate = null;
		try {
			finalDate = dateFormat.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finalDate;
	}
	
}