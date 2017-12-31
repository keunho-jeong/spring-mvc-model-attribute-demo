package com.yandj.springdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

public class CalendarUtils extends DateUtils {
	private static final String DEFAULT_DATE_PATTERN = "yyyyMMddHHmmssSSS";

	public static String getFormattedDate(String pattern, Date date) {
		if (date == null)
			return null;
		if (!StringUtils.hasText(pattern))
			pattern = DEFAULT_DATE_PATTERN;
		return (new SimpleDateFormat(pattern)).format(date);
	}
	
	public static String getFormattedDate(String pattern, long currentTimeMillis) {
		
		Date resultdate = new Date(currentTimeMillis);
		if (!StringUtils.hasText(pattern))
			pattern = DEFAULT_DATE_PATTERN;
		return (new SimpleDateFormat(pattern)).format(resultdate);
	}

	public static Date getDate(String pattern, String date) {
		if (date == null)
			return null;
		if (!StringUtils.hasText(pattern))
			pattern = DEFAULT_DATE_PATTERN;
		try {
			return (new SimpleDateFormat(pattern)).parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException((new StringBuilder()).append("�־��� ��¥�� �Ľ��� �� �����ϴ�. : [pattern : ")
					.append(pattern).append(" / date : ").append(date).append(" ]").toString());
		}
	}

	public static long getTimesSecond(Date startDate, Date endDate) {
		if (startDate == null || endDate == null)
			throw new IllegalArgumentException("�־��� ��¥�� null �Դϴ�.");
		if (startDate.compareTo(endDate) > 0)
			throw new IllegalArgumentException("�񱳵Ǵ� ��¥�� ���İ� �߸��Ǿ����ϴ�.");
		else
			return (long) Math.round((float) (endDate.getTime() - startDate.getTime()) / 1000F);
	}

	public static Date convertTimezone(Date date, TimeZone tz) {
		if (date == null)
			throw new IllegalArgumentException("�־��� ��¥�� null �Դϴ�.");
		if (tz == null) {
			throw new IllegalArgumentException("�־��� TimeZone�� null �Դϴ�.");
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTimeZone(TimeZone.getTimeZone("UTC"));
			cal.setTime(date);
			cal.setTimeZone(tz);
			return cal.getTime();
		}
	}
}
