package com.web.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.util.StringUtils;

import com.model.user.UserPreference;
import com.time.DateTimePattern;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;;


// TODO: Auto-generated Javadoc
/**
 * The Class FormattingHelper.
 * based on java 8 joda date API
 */
public class FormattingHelper implements FormattingConstant{



   /** The request. */
   private HttpServletRequest request = null;

   /** The session. */
   private HttpSession session = null;

   /** The dateformatter. */
   private DateTimeFormatter dateformatter = null;

   /** The timeformatter. */
   private DateTimeFormatter timeformatter = null;

   /** The zoned date time formatter. */
   private DateTimeFormatter zonedDateTimeFormatter = null;

   /** The user time zone. */
   private TimeZone userTimeZone = null;

   /** The client time zone. */
   private TimeZone clientTimeZone = null;

   /** The display time zone. */
   private TimeZone displayTimeZone = null;
   
   /** The number formatter. */
   private NumberFormat numberFormatter = NumberFormat.getNumberInstance();
   
   /** The percent formatter. */
   private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
   
   /** The currency formatter. */
   private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

   /** The Constant SPACE. */
   public static final String SPACE = " ";

   /** The Constant TIMEZONE. */
   private static final String TIMEZONE = "timezone";

   /** The Constant CLIENT_TIMEZONE. */
   private static final String CLIENT_TIMEZONE = "clientTimeZone";
   
   private UserPreference userPreference;
   




   
   /**
    * Instantiates a new tms formating helper.
    * @param request the request
    */
   public FormattingHelper(HttpServletRequest request) {
      if (request != null && request.getSession(false)!=null) {
         this.request = request;
         this.session = request.getSession(false);
         this.userPreference = (UserPreference)session.getAttribute("userPrefBean");
         this.dateformatter =DateTimeFormatter.ofPattern(userPreference.getDatePattern());
         this.timeformatter = DateTimeFormatter.ofPattern(userPreference.getTimePatternt());
         this.zonedDateTimeFormatter = DateTimeFormatter.ofPattern(userPreference.getDatePattern()+userPreference.getTimePatternt());
        
         this.numberFormatter = (NumberFormat)session.getAttribute(NUMBER_FORMAT);
         this.percentFormatter = (NumberFormat)session.getAttribute(PERCENTAGE_FORMAT);
         this.currencyFormatter = (NumberFormat)session.getAttribute(CURRENCY_NUMBER_FORMAT);
         this.userTimeZone = (TimeZone)session.getAttribute(TIME_ZONE);
         this.clientTimeZone = (TimeZone)session.getAttribute(CLIENT_TIME_ZONE);
         displayTimeZone = clientTimeZone;
         
      } else {
         init(true, null, null, null, null, null, TimeZone.getDefault());
      }
   }
   
   

   /**
    * Instantiates a new tms formating helper.
    * @param is12HourFormat the is 12 hour format
    * @param locale         the locale
    */
   public FormattingHelper(boolean is12HourFormat, Locale locale) {
      init(is12HourFormat, null, null, null, null, locale, null);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param is12HourFormat the is 12 hour format
    */
   public FormattingHelper(boolean is12HourFormat) {
      init(is12HourFormat, null, null, null, null, null, TimeZone.getDefault());
   }

   /**
    * Instantiates a new tms formating helper.
    * @param is12HourFormat the is 12 hour format
    * @param timezone       the timezone
    */
   public FormattingHelper(boolean is12HourFormat, TimeZone timezone) {
      init(is12HourFormat, null, null, null, null, null, timezone);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param is12HourFormat  the is 12 hour format
    * @param currencyISOCode the currency ISO code
    * @param timezone        the timezone
    */
   public FormattingHelper(boolean is12HourFormat, String currencyISOCode, TimeZone timezone) {
      init(is12HourFormat, null, null, null, currencyISOCode, null, timezone);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param tmsDateTimePattern the tms date time pattern
    * @param timezone           the timezone
    */
   public FormattingHelper(DateTimePattern tmsDateTimePattern, TimeZone timezone) {
      super();
      init(false, null, tmsDateTimePattern != null ? tmsDateTimePattern.getPattern() : null, null, null, null, timezone);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param dateTimePattern the date time pattern
    * @param timezone        the timezone
    */
   public FormattingHelper(String dateTimePattern, TimeZone timezone) {
      super();
      init(false, null, dateTimePattern, null, null, null, timezone);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param datePattern     the date pattern
    * @param dateTimePattern the date time pattern
    * @param fimeFormat      the fime format
    * @param timezone        the timezone
    */
   public FormattingHelper(DateTimePattern datePattern, DateTimePattern dateTimePattern, DateTimePattern fimeFormat, TimeZone timezone) {
      super();
      init(false, datePattern != null ? datePattern.getPattern() : null, dateTimePattern != null ? dateTimePattern.getPattern() : null, fimeFormat != null ? fimeFormat.getPattern() : null, null, null, timezone);
   }

   /**
    * Instantiates a new tms formating helper.
    * @param is12HourFormat  the is 12 hour format
    * @param currencyISOCode the currency ISO code
    * @param locale          the locale
    * @param timezone        the timezone
    */
   public FormattingHelper(boolean is12HourFormat, String currencyISOCode, Locale locale, TimeZone timezone) {
      super();
      init(is12HourFormat, null, null, null, currencyISOCode, locale, timezone);
   }

   /**
    * Tms formating helper.
    * @param is12HourFormat  the is 12 hour format
    * @param datePattern     the date pattern
    * @param dateTimePattern the date time pattern
    * @param fimeFormat      the fime format
    * @param currencyISOCode the currency ISO code
    * @param timezone        the timezone
    */
   private void FormattingHelper(boolean is12HourFormat, String datePattern, String dateTimePattern, String fimeFormat, String currencyISOCode, TimeZone timezone) {
      init(is12HourFormat, null, null, null, currencyISOCode, null, timezone);
   }

   /**
    * Inits the.
    * @param is12HourFormat  the is 12 hour format
    * @param datePattern     the date pattern
    * @param dateTimePattern the date time pattern
    * @param fimeFormat      the fime format
    * @param currencyISOCode the currency ISO code
    * @param locale          the locale
    * @param timezone        the timezone
    */
   private void init(boolean is12HourFormat, String datePattern, String dateTimePattern, String fimeFormat, String currencyISOCode, Locale locale, TimeZone timezone) {

      if (locale != null) {
         Calendar c = new GregorianCalendar(locale);
         c.getTimeZone();
         numberFormatter = NumberFormat.getNumberInstance(locale);
         percentFormatter = NumberFormat.getPercentInstance(locale);
         currencyFormatter = NumberFormat.getCurrencyInstance(locale);
      }
      displayTimeZone = timezone != null ? timezone : (locale != null ? new GregorianCalendar(locale).getTimeZone() : TimeZone.getDefault());
      dateformatter = DateTimeFormatter.ofPattern(!StringUtils.isEmpty(datePattern) ? datePattern : DateTimePattern.BRITISH_DATE.getPattern());
      if (!StringUtils.isEmpty(fimeFormat)) {
         timeformatter = DateTimeFormatter.ofPattern(fimeFormat);
      } else {
         timeformatter = DateTimeFormatter.ofPattern(is12HourFormat ? DateTimePattern.TIME_HOUR_MIN_SEC_AM_PM.getPattern() : DateTimePattern.TIME_HOUR_MIN_SEC_24.getPattern());
      }

      if (!StringUtils.isEmpty(dateTimePattern)) {
         zonedDateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
      } else {
         zonedDateTimeFormatter = DateTimeFormatter.ofPattern(is12HourFormat ? DateTimePattern.BRITISH_DATE_TIME_AM_PM.getPattern() + DateTimePattern.TIMEZONE.getPattern() : DateTimePattern.BRITISH_DATE_TIME_24.getPattern() + DateTimePattern.TIMEZONE.getPattern());
      }
      numberFormatter.setMinimumFractionDigits(2);
      percentFormatter.setMinimumFractionDigits(2);
      currencyFormatter.setMinimumFractionDigits(2);
      if (!StringUtils.isEmpty(currencyISOCode)) {
         currencyFormatter.setCurrency(Currency.getInstance(currencyISOCode));
      }
   }

   /**
    * Gets the user date formatted.
    * @param date             the date
    * @param customDateFormat the custom date format
    * @return the user date formatted
    */
   public String getUserDateFormatted(Date date, SimpleDateFormat customDateFormat) {
      if (date != null) {
         DateTimeFormatter df = customDateFormat != null ? DateTimeFormatter.ofPattern(customDateFormat.toPattern()) : dateformatter;
         ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), displayTimeZone.toZoneId());
         return df.format(zonedDateTime);
      }
      return "";
   }

   /**
    * Gets the user date formatted.
    * @param date             the date
    * @param customDateFormat the custom date format
    * @param timeZone         the time zone
    * @return the user date formatted
    */
   public String getUserDateFormatted(Date date, SimpleDateFormat customDateFormat, TimeZone timeZone) {
      if (date != null) {
         DateTimeFormatter df = customDateFormat != null ? DateTimeFormatter.ofPattern(customDateFormat.toPattern()) : dateformatter;
         TimeZone tz = timeZone != null ? timeZone : displayTimeZone;
         ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), tz.toZoneId());
         return df.format(zonedDateTime);
      }
      return "";
   }

   /**
    * Gets the user date formatted.
    * @param date the date
    * @return the user date formatted
    */
   public String getUserDateFormatted(Date date) {
      String formattedDate = "";
      if (date != null) {
         ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), displayTimeZone.toZoneId());
         formattedDate = zonedDateTimeFormatter.format(zonedDateTime);
      }
      return formattedDate;
   }

   /**
    * Gets the date time.
    * @param date           the date
    * @param isWithTimeZone the is with time zone
    * @return the date time
    */
   public String getDateTime(Date date, boolean isWithTimeZone) {
      String formattedDate = "";
      if (date != null) {
         ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), displayTimeZone.toZoneId());
         if (isWithTimeZone) {
            formattedDate = zonedDateTimeFormatter.format(zonedDateTime);
         } else {
            formattedDate = getUserDateFormatted(date, new SimpleDateFormat(DateTimePattern.BRITISH_DATE_TIME_24.getPattern()));
         }
      }
      return formattedDate;
   }

  


   /**
    * Convert date to dest time zone.
    * @param date       the date
    * @param destZoneId the dest zone id
    * @param pattern    the pattern
    * @return the string
    */
   public static String convertDateToDestTimeZone(Date date, ZoneId destZoneId, String pattern) {
      String dateString = "";
      if (date != null && destZoneId != null &&! StringUtils.isEmpty(pattern)) {
         ZonedDateTime zoneDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), destZoneId);
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
         dateString = dateTimeFormatter.format(zoneDateTime);
      }
      return dateString;
   }

   /**
    * Convert date to dest time zone.
    * @param date            the date
    * @param destTimeZone    the dest time zone
    * @param dateTimePattern the date time pattern
    * @param isWithTimeZone  the is with time zone
    * @return the string
    */
   public static String convertDateToDestTimeZone(Date date, TimeZone destTimeZone, DateTimePattern dateTimePattern, boolean isWithTimeZone) {
      String timezone = isWithTimeZone ? dateTimePattern.TIMEZONE.getPattern() : "";
      return convertDateToDestTimeZone(date, destTimeZone != null ? destTimeZone.toZoneId() : null, dateTimePattern != null ? dateTimePattern.getPattern() + timezone : null);
   }

   /**
    * Gets the formatted date time.
    * @param date            the date
    * @param dateTimePattern the date time pattern
    * @return the formatted date time
    * @throws Exception the exception
    */
   public static String getFormattedDateTime(Date date, String dateTimePattern) throws Exception {
      String formattedDate = "";
      if (date != null && dateTimePattern != null) {
         LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
         formattedDate = dateTimeFormatter.format(localDateTime);
      }
      return formattedDate;
   }

   /**
    * Gets the formatted date time.
    * @param date            the date
    * @param dateTimePattern the date time pattern
    * @param isWithTimeZone  the is with time zone
    * @return the formatted date time
    * @throws Exception the exception
    */
   public static String getFormattedDateTime(Date date, DateTimePattern dateTimePattern, boolean isWithTimeZone) throws Exception {
      String formattedDate = "";
      if (date != null && dateTimePattern != null) {
         String timezone = isWithTimeZone ? dateTimePattern.TIMEZONE.getPattern() : "";
         LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern.getPattern() + timezone);
         formattedDate = dateTimeFormatter.format(localDateTime);
      }
      return formattedDate;
   }

   

   

   /**
    * Gets the currency format.
    * @param number the number
    * @return the currency format
    */
   public String getCurrencyFormat(Number number) {
      return currencyFormatter.format(number);
   }

   /**
    * Gets the formatted num value.
    * @param number the number
    * @return the formatted num value
    */
   public String getFormattedNumValue(Number number) {
      return numberFormatter.format(number);
   }

  
   /**
    * Gets the formatted with currency.
    * @param value               the value
    * @param currency            the currency
    * @param isCurrencyCodeBefor the is currency code befor
    * @return the formatted with currency
    */
   public String getFormattedWithCurrency(BigDecimal value, Currency currency, boolean isCurrencyCodeBefor) {
      String formattedValue = "";
      if (value != null && currency != null) {
         if (isCurrencyCodeBefor) {
            currencyFormatter.setCurrency(currency);
            formattedValue = currencyFormatter.format(value.doubleValue());
         } else {
            formattedValue = currencyFormatter.format(value.doubleValue()) + SPACE + currency.getCurrencyCode();
         }
      }
      return formattedValue;
   }

 
}
