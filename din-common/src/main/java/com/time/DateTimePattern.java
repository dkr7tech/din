package com.time;

import java.util.LinkedHashMap;
import java.util.Map;

public enum DateTimePattern {

	BRITISH_DATE(1, "dd-MM-yyyy", "05-02-2019", "British"),
	BRITISH_DATE_TIME_24(2, "dd-MM-yyyy HH:mm:ss", "05-02-2019 19:29:01", "British"),
	BRITISH_DATE_TIME_12(3, "dd-MM-yyyy hh:mm:ss", "05-02-2019 07:29:01", "British"),
	BRITISH_DATE_TIME_AM_PM(4, "dd-MM-yyyy hh:mm:ss a", "05-02-2019 07:29:01 PM", "British"),
	BRITISH_DATE_TIME_MILLI_24(5, "dd-MM-yyyy HH:mm:ss.SSS", "05-02-2019 19:29:01.927", "British"),
	BRITISH_DATE_TIME_MILLI_12(6, "dd-MM-yyyy hh:mm:ss.SSS", "05-02-2019 07:29:01.927", "British"),
	BRITISH_DATE_TIME_MILLI_AM_PM(7, "dd-MM-yyyy hh:mm:ss.SSS a", "05-02-2019 07:29:01.927 PM", "British"),

	BRITISH_DATE_FMT2(8, "dd/MM/yyyy", "05/02/2019", "British"),
	BRITISH_DATE_TIME_24_FMT2(9, "dd/MM/yyyy HH:mm:ss", "05/02/2019 19:29:01", "British"),
	BRITISH_DATE_TIME_12_FMT2(10, "dd/MM/yyyy hh:mm:ss", "05/02/2019 07:29:01", "British"),
	BRITISH_DATE_TIME_AM_PM_FMT2(11, "dd/MM/yyyy hh:mm:ss a", "05/02/2019 07:29:01 PM", "British"),
	BRITISH_DATE_TIME_MILLI_24_FMT2(12, "dd/MM/yyyy HH:mm:ss.SSS", "05/02/2019 19:29:01.927", "British"),
	BRITISH_DATE_TIME_MILLI_12_FMT2(13, "dd/MM/yyyy hh:mm:ss.SSS", "05/02/2019 07:29:01.927", "British"),
	BRITISH_DATE_TIME_MILLI_AM_PM_FMT2(14, "dd/MM/yyyy hh:mm:ss.SSS a", "05/02/2019 07:29:01.927 PM", "British"),

	AMERICAN_DATE(15, "MM-dd-yyyy", "02-05-2019", "American"),
	AMERICAN_DATE_TIME_24(16, "MM-dd-yyyy HH:mm:ss", "02-05-2019 19:31:22", "American"),
	AMERICAN_DATE_TIME_12(17, "MM-dd-yyyy hh:mm:ss", "02-05-2019 07:31:22 PM", "American"),
	AMERICAN_DATE_TIME_AM_PM(18, "MM-dd-yyyy hh:mm:ss a", "02-05-2019 07:31:22.994 PM", "American"),
	AMERICAN_DATE_TIME_MILLI_24(19, "MM-dd-yyyy HH:mm:ss.SSS", "02-05-2019 19:31:22.994", "American"),
	AMERICAN_DATE_TIME_MILLI_12(20, "MM-dd-yyyy hh:mm:ss.SSS", "02-05-2019 07:31:22.994", "American"),
	AMERICAN_DATE_TIME_MILLI_AM_PM(21, "MM-dd-yyyy hh:mm:ss.SSS a", "2019-02-05 02:07:43 PM", "American"),

	AMERICAN_DATE_FMT2(22, "MM/dd/yyyy", "02/05/2019", "American"),
	AMERICAN_DATE_TIME_24_FMT2(23, "MM/dd/yyyy HH:mm:ss", "02/05/2019 19:31:22", "American"),
	AMERICAN_DATE_TIME_12_FMT2(24, "MM/dd/yyyy hh:mm:ss", "02/05/2019 07:31:22 PM", "American"),
	AMERICAN_DATE_TIME_AM_PM_FMT2(25, "MM/dd/yyyy hh:mm:ss a", "02/05/2019 07:31:22.994 PM", "American"),
	AMERICAN_DATE_TIME_MILLI_24_FMT2(26, "MM/dd/yyyy HH:mm:ss.SSS", "02/05/2019 19:31:22.994", "American"),
	AMERICAN_DATE_TIME_MILLI_12_FMT2(27, "MM/dd/yyyy hh:mm:ss.SSS", "02/05/2019 07:31:22.994", "American"),
	AMERICAN_DATE_TIME_MILLI_AM_PM_FMT2(28, "MM/dd/yyyy hh:mm:ss.SSS a", "2019/02/05 02:07:43 PM", "American"),

	JAPANESE_DATE(29, "yyyy-MM-dd", "2019-02-05", "Japanese"),
	JAPANESE_TIME_24(30, "yyyy-MM-dd HH:mm:ss", "2019-02-05 19:33:43", "Japanese"),
	JAPANESE_DATE_TIME_12(31, "yyyy-MM-dd hh:mm:ss", "2019-02-05 07:33:43", "Japanese"),
	JAPANESE_DATE_TIME_AM_PM(32, "yyyy-MM-dd hh:mm:ss a", "2019-02-05 07:33:43 PM", "Japanese"),
	JAPANESE_TIME_MILLI_24(33, "yyyy-MM-dd HH:mm:ss.SSS", "2019-02-05 19:33:43.680", "Japanese"),
	JAPANESE_DATE_MILLI_TIME_12(34, "yyyy-MM-dd hh:mm:ss.SSS", "2019-02-05 07:33:43.680", "Japanese"),
	JAPANESE_DATE_MILLI_TIME_AM_PM(35, "yyyy-MM-dd hh:mm:ss.SSS a", "2019-02-05 07:33:43.680 PM", "Japanese"),

	JAPANESE_DATE_FMT2(36, "yyyy/MM/dd", "2019/02/05", "Japanese"),
	JAPANESE_TIME_24_FMT2(37, "yyyy/MM/dd HH:mm:ss", "2019/02/05 19:33:43", "Japanese"),
	JAPANESE_DATE_TIME_12_FMT2(38, "yyyy/MM/dd hh:mm:ss", "2019/02/05 07:33:43", "Japanese"),
	JAPANESE_DATE_TIME_AM_PM_FMT2(39, "yyyy/MM/dd hh:mm:ss a", "2019/02/05 07:33:43 PM", "Japanese"),
	JAPANESE_TIME_MILLI_24_FMT2(40, "yyyy/MM/dd HH:mm:ss.SSS", "2019/02/05 19:33:43.680", "Japanese"),
	JAPANESE_DATE_MILLI_TIME_12_FMT2(41, "yyyy/MM/dd hh:mm:ss.SSS", "2019/02/05 07:33:43.680", "Japanese"),
	JAPANESE_DATE_MILLI_TIME_AM_PM_FMT2(42, "yyyy/MM/dd hh:mm:ss.SSS a", "2019/02/05 07:33:43.680 PM", "Japanese"),

	DATE_MONTH_YEAR(43, "dd-MMM-yyyy", "05-Feb-2019", ""), 
	DATE_MONTH_YEAR_SP(44, "dd MMM yyyy", "05 Feb 2019", ""),
	DAY_DATE_MONTH_TIME_24(45, "EEE, dd MMM yyyy HH:mm:ss", "Tue, 5 Feb 2019 19:08:06", ""),
	DAY_DATE_MONTH_TIME_12(46, "EEE, dd MMM yyyy hh:mm:ss", "Tue, 5 Feb 2019 07:08:06", ""),
	DAY_DATE_MONTH_TIME_AM_PM(47, "EEE, dd MMM yyyy hh:mm:ss a", "Tue, 5 Feb 2019 07:08:06 PM", ""),

	DATE_MONTH_TIME_24(48, "dd MMM yyyy HH:mm:ss", "5 Feb 2019 19:08:06", ""),
	DATE_MONTH_TIME_12(49, "dd MMM yyyy hh:mm:ss", "5 Feb 2019 07:08:06", ""),
	DATE_MONTH_TIME_AM_PM(50, "dd MMM yyyy hh:mm:ss a", "5 Feb 2019 07:08:06 PM", ""),

	TIME_HOUR_MIN_SEC_24(51, "HH:mm:ss", "19:33:43", ""), 
	TIME_HOUR_MIN_SEC_12(52, "hh:mm:ss", "07:33:43", ""),
	TIME_HOUR_MIN_SEC_AM_PM(53, "hh:mm:ss a", "07:33:43 PM", ""),

	AM_PM(54, " a ", "PM", ""), 
	MILLISECONDS(55, " S ", "056", ""), 
	TIMEZONE(56, " z ", "IST", ""),
	TIMEZONE_GMT_OFFSET(57, " ZZZZ ", "GMT+05:30", ""), 
	TIMEZONE_OFFSET(58, " ZZZ ", "+05:30", ""),

	;

	int id;
	String pattern;
	String description;
	String type;

	private DateTimePattern(int id, String pattern, String description, String type) {
		this.id = id;
		this.pattern = pattern;
		this.description=description;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getPattern() {
		return pattern;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public static DateTimePattern getPatternById(int id) {
		DateTimePattern dateTimePattern=null;
		DateTimePattern[] dateTimePatterns=DateTimePattern.values();
		for(DateTimePattern timePattern : dateTimePatterns) {
			if(id==timePattern.id) {
				dateTimePattern=timePattern;
				break;
			}
		}
		return dateTimePattern;
		
	}
	public static Map<String, String> getDateTimePatternMap() {
		Map<String, String> patternMap = new LinkedHashMap<String, String>();
		for (DateTimePattern timePattern : DateTimePattern.values()) {
			if (timePattern.id < 51) {
				patternMap.put(String.valueOf(timePattern.id), timePattern.type + " " + timePattern.pattern + " ex. " + timePattern.description);
			}
		}
		return patternMap;
	}

}
