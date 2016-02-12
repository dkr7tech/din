package com.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.util.StringUtils;

public class StringUtility {



	public final static String NEWLINE = System.getProperty("line.separator");

    //Feature : 16832
    public static final int STRING_LENGTH_255 = 255;

	/**
	 * Finds index of the first digit in the given String
	 */
	public static int firstDigitAt(String number) {
		int result = -1;
		Pattern p = Pattern.compile("^[^\\p{Digit}]*(\\p{Digit}+).*$");
		if (number != null) {
			Matcher m = p.matcher(number);
			if (m.matches()) {
				result = m.start(1);
			}
		}
		return result;
	}


	/**
	 * Finds index of the first letter in the given String
	 */
	public static int firstLetterAt(String string) {
		int result = -1;
		Pattern p = Pattern.compile("^[^\\p{Alpha}]*(\\p{Alpha}+).*$");
		Matcher m = p.matcher(string);
		if (m.matches()) {
			result = m.start(1);
		}
		return result;
	}


	public static String parseLetters(String string) {
		String result = "";
		Pattern p = Pattern.compile("^(\\p{Alpha}+).*$");
		Matcher m = p.matcher(string);
		if (m.matches()) {
			result = m.group(1);
		}
		return result;
	}


	public static String remove(String remove, String s) {
		return (s != null && remove != null) ? s.replaceFirst(remove, "") : s;
	}


	public static String removeAll(String remove, String s) {
		return (s != null && remove != null) ? s.replaceAll(remove, "") : s;
	}


	/**
	 * Much like String.replace(char, char), but searches for and replaces with
	 * Strings, not characters.
	 *
	 * @param str String -- original, unaltered String
	 * @param searchStr String -- substring to search for
	 * @param replaceStr String -- substring to replace with
	 */
	public static String replace(String str, String searchStr, String replaceStr) {
		if (str == null) {
			return null;
		}
		if (searchStr == null || searchStr.equals("")) {
			return str;
		}
		if (replaceStr == null) {
			replaceStr = "";
		}
		int searchIndex = 0;
		int foundIndex;
		while ((foundIndex = str.indexOf(searchStr, searchIndex)) > -1) {
			str = str.substring(0, foundIndex) + replaceStr + str.substring(foundIndex + searchStr.length());
			searchIndex = foundIndex + replaceStr.length();
		}
		return str;
	}


	/**
	 * Does the following:
	 * int length = 3;
	 * createQueryInClausePlaceHolder(length);
	 * Output: ?,?,?
	 *
	 * @param objects
	 * @return
	 */
	public static String createQueryInClausePlaceHolder(int length) {
		StringBuilder buf = new StringBuilder();
		if (length > 0) {
			buf.append('?');
		} else {
			return "";
		}

		for (int i = 1; i < length; i++) {
			buf.append(",?");
		}
		return buf.toString();
	}


	public static String toString(Collection<?> c) {
		return c != null ? c.toString() : "null";
	}


	/**
	 * Does the following:
	 * int [] someInts = new int {32, 43, 29, 0};
	 * arrayToString(someInts);
	 * Output: (32, 43, 39, 0)
	 *
	 * @param objects
	 * @return
	 */
	public static String arrayToString(Object objects) {
		if (objects == null) {
			return "null";
		}
		Class<?> typeClass = objects.getClass();

		if (typeClass.isArray()) {
			StringBuilder buf = new StringBuilder();
			buf.append("(");

			for (int i = 0; i < Array.getLength(objects); i++) {
				if (i > 0) {
					buf.append(", ");
				}

				buf.append(arrayToString(Array.get(objects, i)));
				// recursive call for nested arrays
			}

			buf.append(")");
			return buf.toString();
		} else {
			return objects.toString();
		}
	}


	/**
	 * Does the following:
	 * List someInts = {32, 43, 29, 0};
	 * listToString(someInts);
	 * Output: (32, 43, 39, 0)
	 *
	 * @param objects
	 * @return
	 */
	public static String listToString(List<?> objects) {
		if (objects == null) {
			return "null";
		}

		StringBuilder buf = new StringBuilder();
		buf.append("(");

		for (int i = 0; i < objects.size(); i++) {
			if (i > 0) {
				buf.append(", ");
			}

			if (objects.get(i).getClass().isArray()) {
				buf.append(arrayToString(objects.get(i)));
				// recursive call for nested arrays
			}
			if (objects.get(i) instanceof List<?>) {
				buf.append(listToString((List) objects.get(i)));
				// recursive call for nested arrays
			} else {
				buf.append(objects.get(i).toString());
			}
		}

		buf.append(")");
		return buf.toString();
	}


	/**
	 * transform string to array of strings with white space as delimiter.
	 */
	public static String[] toStringArray(String str) {
		ArrayList<String> strList = new ArrayList<String>();

		if (str != null) {
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				strList.add(st.nextToken());
			}
		}
		return strList.toArray(new String[0]);
	}


	/**
	 * This method takes string contains numbers delimeted by delim str, return set of number string
	 *
	 * @param str
	 * @param delim
	 * @return Set of unique number string
	 */
	public static Set<String> toUniqDigitalStringSet(String str, String delim) {
		Set<String> stringSet = new LinkedHashSet<String>();
		if (str == null) {
			return stringSet;
		}

		if (delim == null) {
			delim = " "; //default
		}

		String oneToken = null;
		StringTokenizer st = new StringTokenizer(str, delim);
		while (st.hasMoreTokens()) {
			oneToken = st.nextToken();
			if (isDigit(oneToken)) {
				stringSet.add(oneToken);
			}
		}
		return stringSet;
	}


	public static String toSmartCase(String s) {
		if (s != null) {
			StringBuilder newS = new StringBuilder(s.toLowerCase());
			newS.replace(0, 1, s.substring(0, 1).toUpperCase());
			return newS.toString();
		}
		return s;
	}


	/**
	 * Converts an array of objects to a delimited String
	 *
	 * @param - Array of Objects with a useful toString() method
	 * @param delimiter - The delimiter
	 * @return A String, delimited as defined
	 */
	public static String toString(Object[] strs, String delimiter) {
		StringBuilder sb = new StringBuilder();

		if (strs != null) {
			for (int i = 0; i < strs.length; i++) {
				sb.append(strs[i]);
				if (i < strs.length - 1) {
					sb.append(delimiter);
				}
			}
		}
		return sb.toString();

	}


	/**
	 * @return strings delimited with a space in between.
	 */
	public static String toString(Object[] strings) {
		return toString(strings, " ");
	}


	/**
	 * @return string containing comma separated values
	 */
	public static String toCSVString(int[] vals) {
		return toCSVString((Object) vals);
	}


	/**
	 * @return string containing comma separated values
	 */
	public static String toCSVString(Integer[] vals) {
		return toCSVString((Object) vals);
	}


	/**
	 * @return string containing comma separated values
	 */
	public static String toCSVString(long[] vals) {
		return toCSVString((Object) vals);
	}


	/**
	 * @return string containing comma separated values
	 */
	public static String toCSVString(String[] vals) {
		return toCSVString(vals, false);
	}


	/**
	 * @return string containing comma separated values
	 */
	public static String toCSVString(String[] vals, boolean padSpace) {
		return toCSVString((Object) vals, padSpace);
	}


	static String toCSVString(Object array) {
		return (toCSVString(array, false));
	}


	static String toCSVString(Object array, boolean padSpace) {
		if (array == null) {
			return "";
		}

		int size = Array.getLength(array);
		StringBuilder sb = new StringBuilder();
		if (size > 0) {
			sb.append(Array.get(array, 0));
			String delim = padSpace ? ", " : ",";
			for (int i = 1; i < size; i++) {
				sb.append(delim).append(Array.get(array, i));
			}
		}
		return sb.toString();
	}


	/**
	 * returns a list of values
	 *
	 * @param set the values to list
	 * @return
	 */
	public static String toCSVString(Collection<?> set) {
		return toCSVString(set, false);
	}


	public static String toCSVString(Collection<?> coll, boolean padSpace) {
		return toCSVString(coll, false, padSpace);
	}


	/**
	 * Converts the elements in the array list to a single line of comma separated values.
	 * Utility method used in CSV export.
	 *
	 * @param coll
	 * @param toCSVString
	 * @param padSpace
	 * @return
	 */
	public static String toCSVString(Collection<?> coll, boolean quoteValue, boolean padSpace) {
		if (coll == null || coll.size() <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		String delim = padSpace ? ", " : ",";
		for (Iterator<?> iter = coll.iterator(); iter.hasNext(); ) {
			Object obj = iter.next();
			String strVal = obj == null ? "" : obj.toString();
			sb.append(quoteValue ? quoteCSVValue(strVal) : strVal);

			// add a comma if this is not the last value
			if (iter.hasNext()) {
				sb.append(delim);
			}
		} // for iterator over set
		return sb.toString();
	}


	/**
	 * @param obj
	 * @return
	 */
	public static String quoteCSVValue(String str) {
		String retVal = "";
		if (str.length() > 0) {
			// enclose values in double quotes (escape any embedded double quotes first)
			if (str.indexOf("\"") != -1) {
				retVal = StringUtils.replace(str, "\"", "\"\"");
			} else {
				retVal = str;
			}
			retVal = "\"" + retVal + "\"";
		}
		return retVal;
	}


	/**
	 * Check that every char in the input string is a digit.
	 *
	 * @param string String to check.
	 * @return boolean whether input string is all digits.
	 */
	public static boolean isDigit(String string) {
		return string.matches("^\\p{Digit}+$");
	}


	/**
	 * Check that every char in the input string is a letter.
	 *
	 * @param string String to check.
	 * @return boolean whether input string is all letters.
	 */
	public static boolean isLetter(String string) {
		return string.matches("^\\p{Alpha}+$");
	}


	/**
	 * Checks to see if a string is null or empty with a flexibility to consider
	 * spaces as valid empty string. For the String to be empty it has to satisfy one of these conditions:
	 * <ul>
	 * <li>It is null</li>
	 * <li>If allowSpaces is true, it is either empty or it is just whitespace</li>
	 * <li>Or if allowSpaces is false, it is just an empty string.</li>
	 * </ul>
	 *
	 * @param s The string to check
	 * @return boolean
	 */
	public static boolean isEmpty(String s, boolean allowSpaces) {
		boolean isEmpty = (s == null);
		if (!isEmpty) {
			int len =  (allowSpaces ? s.trim().length() : s.length()); // pmd_ignore : Ignore the false positive. s can never be null here.
			isEmpty = (len == 0);
		}
		return isEmpty;
	}


	/**
	 * Checks to see if a string is null or empty.
	 * For the String to be empty it has to satisfy one of these conditions:
	 * <ul>
	 * <li>It is null</li>
	 * <li>It is empty</li>
	 * <li>Or it is just whitespace</li>
	 * </ul>
	 *
	 * @param s The string to check
	 * @return boolean
	 */
	/*public static boolean isEmpty(String s) {
		return isEmpty(s, true);
	}*/


	/**
	 * Added negation method for #isEmpty as to avoid negative logic in the code.
	 *
	 * @param s
	 * @return true if the String is not empty.
	 */
	public static final boolean isNotEmpty(String s) {
		return (!isEmpty(s));
	}


	public static String trimAll(String s) {
		return (s == null) ? s : s.replaceAll("\\s+", "");
	}


	public static String collapseWhiteSpace(String str) {
		return (str == null) ? "" : str.replaceAll("[\t \n]?", "");
	}


	public static String suppressWhiteSpace(String sText) {
		if (isNotEmpty(sText)) {
			sText = sText.replaceAll("\\s+", "");
			return sText;
		}
		return sText;
	}


	/**
	 * Remove linefeed and carriage return from the string
	 */
	public static String ignoreCarriageReturn(String in) {
		if (in == null) {
			return "";
		}

		String result = in.replaceAll("[\r\n\f]?", "");
		result = result.replaceAll("\\'", "\\\\\\'");
		result = result.replaceAll("\\\"", "\\\\\\\"");

		return result;
	}


	/**
	 * If the string is null, return the empty string
	 *
	 * @param value
	 * @return
	 */
	public static final String cleanNull(String value) {
		return cleanNull(value, "");
	}
	
	public static final String cleanNull(Object value){
		String str;
		if (value == null){
			return "";
		} else{
			str = value.toString();
		}
		return cleanNull(str, "");
	}
	
	public static final String cleanNull(Object value, String defaultValue){
		String str;
		if (value == null){
			return defaultValue;
		} else{
			str = value.toString();
		}
		return cleanNull(str, defaultValue);
	}


	/**
	 * If the string is null return the defaultValue
	 *
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static final String cleanNull(String value, String defaultValue) {
		return (value == null) ? defaultValue : value;
	}


	/**
	 * Cleans the null or empty strings from the string[]
	 *
	 * @param value
	 * @return string array
	 */
	public static final String[] cleanNull(String[] value) {
		if (value == null) {
			return null;
		}
		List<String> strval = new ArrayList<String>();
		String val = null;
		for (int i = 0; i < value.length; i++) {
			val = cleanNull(value[i]);
			if (val != "") {
				strval.add(val);
			}
		}
		return strval.toArray(new String[strval.size()]);
	}


	public static String cleanNullString(String str) {
		String string = cleanNull(str);
		return string.equalsIgnoreCase("null") ? "" : str;
	}


	/**
	 * Cleans a null or empty string
	 *
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static final String cleanEmpty(String value, String defaultValue) {
		return (isEmpty(value)) ? defaultValue : value;
	}


	/**
	 * trims String with null default for all whitespaces
	 *
	 * @param string
	 * @return s either trimmed String or null
	 */
	public static final String toNull(String string) {
		String s = trim(string);
		return isEmpty(s) ? null : s;
	}


	public static final String nullifyEmptyString(String string) {
		String s = trim(string);
		return isEmpty(s) ? null : s;
	}


	/**
	 * Trims the extra space off of a string.
	 *
	 * @param s The string to be trimmed
	 * @return A trimmed string or null if the string was null
	 */
	public static final String trim(String s) {
		return (s == null ? null : s.trim());
	}


	/**
	 * Duplicates Object.toString(), showing type and hashcode.
	 * Note: Calls hashCode() as does Object.toString().
	 * Does not use System.identityHashCode(Object) to avoid virtual overrides.
	 *
	 * @param object to show.
	 * @return String representation of this object
	 */
	public static String object(Object object) {
		return object == null ? null : object.getClass().getName() + '@' + Integer.toHexString(object.hashCode());
	}


	/**
	 * Splits a String object into an array of strings by separating the string
	 * into substrings. The passed string is split by parsing for the
	 * separator parameter.
	 */
	public static String[] split(String str, String separator) {
		return (str == null) ? null : str.split(separator);
	}


	/**
	 * Splits a string using multiple delimiters.
	 * Commonly used to parse some kind of generic field that a user
	 * dumps data into that we're supposed to parse - probably use
	 * delimiters of , <space> <tab> <cr>
	 * null safe - won't return null
	 *
	 * @param str String to split
	 * @param delimiters char array of delimiters
	 */
	public static final String[] split(String str, char[] delimiters) {
		if (str == null) {
			return new String[0];
		}
		LinkedList<String> result = new LinkedList<String>();
		Arrays.sort(delimiters);
		char[] chars = str.toCharArray();
		StringBuilder buf = new StringBuilder();
		for (char aChar : chars) {
			if (Arrays.binarySearch(delimiters, aChar) >= 0) {
				if (buf.length() > 0) {
					result.add(buf.toString());
				}
				buf = new StringBuilder();
			} else {
				buf.append(aChar);
			}
		}
		if (buf.length() > 0) {
			result.add(buf.toString());
		}
		return result.toArray(new String[0]);
	}


	/**
	 * If the given String[] contains all ints, it will return it
	 * as an int[]. If strArr is null, it returns null. If strArr
	 * has non-ints in it, it will return a RuntimeException.
	 */
	public static int[] convertStringArrToIntArr(String[] strArr) {
		if (strArr == null) {
			return null;
		}
		int[] ints = new int[strArr.length];
		try {
			for (int i = 0; i < strArr.length; i++) {
				ints[i] = Integer.parseInt(strArr[i]);
			}
		} catch (NumberFormatException nfe) {
			throw new RuntimeException(
					"Could not convert String[] to int[]: not all Strings were ints: strArr contents: " + arrayToString(strArr));
		}
		return ints;
	}


	public static int[] stringToIntArray(String str, String delimiter) {
		if (isEmpty(str)) {
			return null;
		}
		return convertStringArrToIntArr(str.split(delimiter));
	}


	/**
	 * If the given String[] contains all long values, it will return it
	 * as an long[]. If strArr is null, it returns null. If strArr
	 * has non-long values in it, it will return a RuntimeException.
	 */
	public static long[] convertStringArrToLongArr(String[] strArr) {
		if (strArr == null) {
			return null;
		}

		long[] values = new long[strArr.length];
		try {
			for (int i = 0; i < strArr.length; i++) {
				values[i] = Long.parseLong(strArr[i]);
			}
		} catch (NumberFormatException nfe) {
			throw new RuntimeException(
					"Could not convert String[] to long[]: not all Strings were long: strArr contents: " + arrayToString(strArr));
		}

		return values;
	}


	/**
	 * Returns an array of long values from the input string based on input delimiter.
	 *
	 * @param str String value from which long values are to be extracted.
	 * @param delimiter Delimiter to be used for extraction
	 * @return Array of long values
	 */
	public static long[] stringToLongArray(String str, String delimiter) {
		if (isEmpty(str)) {
			return null;
		}
		return convertStringArrToLongArr(str.split(delimiter));
	}


	/**
	 * Turns the String xyz into XYZ or the null String to "";
	 */
	public static final String toUpperCase(String s) {
		return (s != null) ? s.trim().toUpperCase() : "";
	}


	/**
	 * zero pads a string until it is a certain size.
	 *
	 * @param size
	 * @param x
	 * @return
	 */
	public static final String zeroPad(int size, String x) {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isEmpty(x)) {
			for (int i = 0; i < size; i++) {
				sb.append("0");
			}
		} else if (x.length() >= size) {
			sb.append(x);
		} else if (x.length() < size) {
			for (int i = x.length(); i < size; i++) {
				sb.append("0");
			}
			sb.append(x);
		}

		return sb.toString();
	}


	/**
	 * Pads a string out to desired length.
	 * If the truncate flag is true, the string will be shortened if it is longer than
	 * the desired length, otherwise, it will be returned as-is.
	 *
	 * @param
	 * @param size
	 * @return
	 */
	public static final String padString(String str, int size, boolean truncate) {
		if (str == null) {
			return null;
		}
		if (truncate && str.length() >= size) {
			return str.substring(0, size);
		}
		// append the spaces.
		StringBuilder buf = new StringBuilder(str);
		for (int i = str.length(); i < size; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}


	/**
	 * Pads a set of columns to create a string representing a single row.
	 * So, if strings{"foo","bar and then some"}, sizes{10,5}, "  " were passed,
	 * the output would be:
	 * foo bar
	 * and
	 * then
	 * some
	 *
	 * @param : the strings, in column order
	 * @param sizes: the size of each column, corresponding to strings.
	 * @param divider: the column divider (example: "  " or " | ")
	 * @return a string formatted as defined - never null
	 *         Do not pass in nulls for any parameter.
	 *         Note: Does not presently wrap a string to fit in a column... This function
	 *         will truncate strings to fit.
	 */
	/*public static final String padStrings(String[] strs, int[] sizes, String divider) {
		// loop through columns
		LinkedList<String[]> wrappedStrings = new LinkedList<String[]>();
		int maxrows = 0; // the maximum rows in this record
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			int size = sizes[i];
			String[] wrapped = split(WordUtils.wrap(s, size), NEWLINE);
			if (wrapped.length > maxrows) {
				maxrows = wrapped.length;
			}
			for (int j = 0; j < wrapped.length; j++) {
				wrapped[j] = padString(wrapped[j], size, true);
			}
			wrappedStrings.add(wrapped);
		}
		// Now everything is wrapped and split...
		StringBuilder result = new StringBuilder();
		// Loop rows

		for (int i = 0; i < maxrows; i++) {
			// Loop columns
			for (int j = 0; j < wrappedStrings.size(); j++) {
				String[] wrapped = wrappedStrings.get(j);
				if (wrapped.length > i) {
					result.append(wrapped[i]);
				} else {
					// create filler for empty spaces
					char[] spaces = new char[sizes[j]];
					for (int k = 0; k < sizes[j]; k++) {
						spaces[k] = ' ';
					}
					result.append(new String(spaces));
				}
				if (j < wrappedStrings.size() - 1) {
					result.append(divider);
				}
			}
			if (i < maxrows - 1) {
				result.append("\n");
			}
		}
		return result.toString();
	}*/


	/**
	 * Truncates a string to the specified size.
	 *
	 * @param str String
	 * @param size int
	 * @return String
	 */
	public static final String truncate(String str, int size) {
		if (str != null && str.length() > size) {
			return str.substring(0, size);
		}

		return str;
	}


	/**
	 * Turns a coll into a CVS separated String with single quoting. Useful for going to the database.
	 *
	 * @param coll
	 * @return
	 */
	public static final String toQuotedCSVString(Collection<?> coll) {
		if (coll == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();

		for (Iterator<?> iterator = coll.iterator(); iterator.hasNext(); ) {
			Object o = iterator.next();
			sb.append("'");
			sb.append((o == null) ? "NULL" : o.toString());
			sb.append("'");
			if (iterator.hasNext()) {
				sb.append(',');
			}

		} // for iterator over coll

		return (sb.toString());
	}


	/**
	 * Turns a coll into a CVS separated String with single quoting. Usefull for going to the database.
	 *
	 * @param objArray
	 * @return
	 */
	public static final String toQuotedCSVString(Object[] objArray) {
		if (objArray == null || objArray.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int count = objArray.length;
		for (Object obj : objArray) {
			sb.append("\'");
			sb.append((obj == null) ? "NULL" : obj.toString());
			sb.append("\'");
			if (count > 1) {
				sb.append(',');
			}
			count--;
		}

		return (sb.toString());
	}


	/**
	 * Delete the last char n times.
	 *
	 * @param sb
	 * @param n num chars to delete at the end of the buffer
	 */
	public static final void delete(StringBuffer sb, int n) {
		int len = sb.length();
		if (len > n) {
			sb.delete(len - n, len);
		}
	}


	/**
	 * safely convert "1,2,3,4,abc, , , " to Collection of {1,2,3,4 }
	 * confirms no blanks get added as 0 zero
	 * jlemonier 11-28-07. Handy if CSV list of ids are intended for dynamic SQL or params
	 */
	/*public static Collection<Integer> toCollectionOfIntegers(String CSV, String delim) {
		Collection<Integer> result = new ArrayList<Integer>();
		if (null == CSV) {
			return result; // null still returns a blank Collection
		}

		String[] entries = CSV.split(delim);
		for (int i = 0; i < entries.length; i++) {
			String e = entries[i].trim(); // allows spaces
			if (isDigit(e)) {
				result.add(PrimitiveUtils.parseInt(e));
			}
		}
		return result;
	}*/


	/**
	 * Take array of 6 elements, return CSV: "1,a,b,76,d,e"
	 */
	public static String join(Object[] sa, String delim) {
		if (null == sa || sa.length == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sa[0]);
		for (int i = 1; i < sa.length; i++) {
			sb.append(delim).append(sa[i]);
		}
		return sb.toString();
	}


	public static String join(Object[] sa) {
		return join(sa, ",");
	}


	public static String join(Collection<?> list, String delim) {
		if (list == null || list.size() == 0) {
			return "";
		}

		return join(list.toArray(), delim);
	}


	public static String join(Collection<?> list, String delim, boolean cleanNull) {
		if (cleanNull && (list != null && list.size() > 0)) {
			Iterator<?> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				if (obj == null) {
					iterator.remove();
				}
			}
		}
		return join(list, delim);
	}

    public static String constructCSV(Collection<?> list, String delim, boolean cleanNull) {
        if (cleanNull && (list != null && list.size() > 0)) {
            Iterator<?> iterator = list.iterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (obj == null || (obj instanceof String && "".equals(obj))) {
                    iterator.remove();
                }
            }
        }
        return join(list, delim);
    }


	public static String join(Collection<?> list) {
		return join(list, ",");
	}


	public static String join(int[] sa, String delim) {

		if (sa == null || sa.length == 0) {
			return "";
		}
		Integer[] arr = new Integer[sa.length];
		for (int i = 0; i < sa.length; i++) {
			arr[i] = sa[i];
		}

		return join(arr, delim);
	}

	public static boolean isNumber(String str) {
		if (isEmpty(str)) {
			return false;
		}
		try {
			Integer.parseInt(str.trim());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}


	public static int parseInt(String strVal) {
		return (isNumber(strVal) ? Integer.parseInt(strVal) : 0);
	}


	public static boolean hasWildCard(String str) {
		boolean hasWildCard = false;
		if (isNotEmpty(str)) {
			if (str.indexOf("*") != -1 || str.indexOf("%") != -1) {
				hasWildCard = true;
			}
		}
		return hasWildCard;
	}


	/**
	 * Method that counts number of char in string
	 *
	 * @param str Value
	 * @return chara count
	 */
	public static int countCharactersOfString(String str) {
		int charCount = 0;
		if (isNotEmpty(str)) {
			charCount = str.length();
		}
		return charCount;
	}


	/**
	 * Do a simple container number check to see if it conforms the following format:
	 * 4 letters + 6 digits + 1 optional check digit
	 *
	 * @param str
	 * @return
	 */
	public static boolean isValidContainerNumber(String str) {
		return str.matches("[a-zA-Z]{4}[0-9]{6}[0-9]{0,1}");
	}


	public static boolean isValidInteger(Double inputValue) {
		boolean isValidInt = false;
		if (inputValue == (int) Math.round(inputValue)) {
			isValidInt = true;
		}
		return isValidInt;
	}


	public static boolean isInt(double val) {
		return ((val == Math.round(val)));
	}


	public static String getAbbreviation(String s, int limit) {
		int LIMIT = 10;
		if (isEmpty(s)) {
			return "";
		}
		if (limit < 3) {
			limit = LIMIT;
		}
		if (s.length() > limit) {
			return s.substring(0, limit - 3) + "...";
		} else {
			return s;
		}
	}


	/**
	 * Split String By Array of Tokens
	 *
	 * @param String
	 * @return List<String>
	 */
	public static List<String> getSplitList(String source, String[] tokens) {
		for (String token : tokens) {
			source = source.replaceAll(token, tokens[0]);
		}
		return Arrays.asList(source.split(tokens[0]));
	}


	/**
	 * Compresses a string by converting it into a byte array and then using the Deflater on the resulting array.
	 *
	 * @param string the input String to compress. This needs to be a string of valid Unicode characters. A String of random bytes
	 * may not decompress correctly because of encoding conversions.
	 * @return a byte array containing the compressed data stream.
	 * @throws UnsupportedEncodingException Before the actual compression occurs, the String is converted to a UTF-8 byte array.
	 *                                      If the original string contained invalid Unicode character sequences, this exception may be thrown.
	 */
	/*public static byte[] compress(String string) throws UnsupportedEncodingException {
		if (string == null) {
			throw new NullArgumentException("string");
		}
		byte[] inputBytes = string.getBytes("UTF-8");
		// preallocate a buffer that should be more than enough
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream(2 * inputBytes.length + 256);
		DeflaterOutputStream deflater = new DeflaterOutputStream(byteOS, new Deflater(Deflater.BEST_COMPRESSION));
		try {
			deflater.write(inputBytes);
		} catch (IOException e) {
			// Because we are using in-memory IO, this exception should not be thrown. If, for some odd reason, it is, we'll log
			// it and rethrow as a RuntimeException.
			
			throw new RuntimeException(e);
		} finally {
			CloseUtils.close(deflater);
		}
		return byteOS.toByteArray();
	}

*/
	/**
	 * Decompresses the data returned from the compress method to a String.
	 *
	 * @param inputBytes a byte array containing a compressed data stream.
	 * @return a decompressed String
	 * @throws DataFormatException          if the input data stream is corrupted in any way, it will not be able to be decompressed.
	 * @throws UnsupportedEncodingException if the decompressed bytes to not match the UTF-8 encoding format, this exception will
	 *                                      be thrown when the data is converted to Unicode.
	 */
	/*public static String decompress(byte[] inputBytes) throws DataFormatException, UnsupportedEncodingException {
		if (inputBytes == null) {
			throw new NullArgumentException("inputBytes");
		}
		// difficult to predict how much will be large enough, but this will dynamically resize.
		ByteArrayOutputStream byteOS = new ByteArrayOutputStream(2 * inputBytes.length + 32);
		Inflater inflater = new Inflater();
		byte[] buffer = new byte[4096];
		inflater.setInput(inputBytes);
		int size;
		while ((size = inflater.inflate(buffer)) > 0) {
			byteOS.write(buffer, 0, size);
		}
		inflater.end();
		try {
			byteOS.close(); // Doesn't do anything, but for consistency
		} catch (IOException e) {
			// Because we are using in-memory IO, this exception should not be thrown. If, for some odd reason, it is, we'll log
			// it and rethrow as a RuntimeException.
			
			throw new RuntimeException(e);
		}
		return byteOS.toString("UTF-8"); // create a string from utf-8 encoded bytes
	}

*/
	public static boolean isNull(String s) {
		return s == null;
	}


	/**
	 * @param List<String> stringList
	 * @return String[] Non-<code>null</code> result. Will be empty on <code>null</code> input.
	 */
	public static String[] convertListToStringArray(List<String> stringList) {
		if (stringList == null) {
			return new String[] {};
		}
		return stringList.toArray(new String[stringList.size()]);
	}


	/**
	 * Formats a given csv string containing lines with delimited columns as a nice table.
	 * 
	 * @param columnDelimiter
	 *            The delimiter string which is used to separate the columns in
	 *            the lines.
	 * @param columnSeparator
	 *            The separator string to use for the nice table.
	 * @param headerSeparator
	 *            The separator string to use to separate header and body of the
	 *            table. When this is empty it is assumed, that the table has no header.
	 * @param body
	 *            The csv formatted lines.
	 */
	/*public static String csvStringToNiceTable(final String columnDelimiter, final String columnSeparator, final String headerSeparator, String body) {
		if (!StringUtils.isEmpty(body)) {
			// determine column sizes
			final List<Integer> columnSizes = new ArrayList<Integer>();
			final List<List<String>> splittedLines = new ArrayList<List<String>>();
			for (final String line : new ArrayList<String>(Arrays.asList(body.replace("\r\n", "\n").replace("\r", "\n")
					.split("\n")))) {
				final List<String> splittedLine = new ArrayList<String>();
				splittedLines.add(splittedLine);
				int c = 1;
				for (final String column : line.split(columnDelimiter)) {
					splittedLine.add(column.trim());
					if (c > columnSizes.size()) {
						columnSizes.add(0);
					}
					final int cl = column.length();
					if (cl > columnSizes.get(c - 1)) {
						columnSizes.set(c - 1, cl);
					}
					++c;
				}
			}
			// append padding spaces to columns
			final int nc = columnSizes.size();
			for (final List<String> line : splittedLines) {
				for (int c = 0; c < nc; c++) {
					final int cs = columnSizes.get(c);
					final String column = line.get(c);
					final StringBuilder cb = new StringBuilder(column);
					for (int i = column.length(); i < cs; i++) {
						cb.append(" ");
					}
					line.set(c, cb.toString());
				}
			}
			// build final body
			final boolean hasHeader = !isEmpty(headerSeparator);
			final StringBuilder bb = new StringBuilder();
			final int numberOfLines = splittedLines.size();
			for (int i = 0; i < numberOfLines; i++) {
				final String line = StringUtils.join(splittedLines.get(i), columnSeparator);
				bb.append(line);
				if (i < numberOfLines - 1) {
					bb.append("\n");
				}
				if (hasHeader && i == 0) {
					final StringBuilder sep = new StringBuilder();
					for (int s = 0; s < line.length(); s++) {
						sep.append(headerSeparator);
					}
					bb.append(sep);
					bb.append("\n");
				}
			}
			return bb.toString();
		} else {
			return "";
		}
	}
*/
	/**
	 * Method converts string array to XML
	 *
	 * @param strArr
	 * @return
	 */
	/*public static String stringArrayToXML(String[] strArr) {
		if (strArr == null || strArr.length == 0) {
			return null;
		}
		StringBuffer values = new StringBuffer("<node>");
		for (String str : strArr) {
			values.append("<value>");
			values.append(XMLUtils.escape(str));
			values.append("</value>");
		}
		values.append("</node>");
		return values.toString();
	}*/

	/**
	 * Method converts int array to XML
	 *
	 * @param iArr
	 * @return
	 */
	public static String intArrayToXML(int[] iArr) {
		if (iArr == null || iArr.length == 0) {
			return null;
		}
		StringBuffer values = new StringBuffer("<node>");
		for (Integer i : iArr) {
			values.append("<value>");
			values.append(i);
			values.append("</value>");
		}
		values.append("</node>");
		return values.toString();
	}
	
	/**
	 * Method to format a message with the values in the objects array.
	 * 
	 * @param message The message to format with place holders in it.
	 * @param objects The object array containing replaceable values.
	 * 
	 * Example : message = The quick {0} {1} jumped over the lazy {2}.
	 *           objects[] = {"brown","fox","dog"}
	 *           Output: The quick brown fox jumped over the lazy dog.
	 */
	public static String getFormattedMessage(String message, Object[] objects) {
		return MessageFormat.format(message, objects);
	}
	

	/**
	 * @param ids
	 * @param chunkSize
	 * @return
	 */
	public static List<String[]> toListOfStringArrays(String[] ids, int chunkSize) {

		List<String[]> chunks = null;

		if (ids != null && ids.length > 0) {

			chunks = new ArrayList<String[]>();

			for (int index = 0; index < ids.length;) {
				int begin = index;
				int end = begin + chunkSize;
				end = (end > ids.length ? ids.length : end);

				String[] chunk = new String[end - begin];
				for (int j = 0, i = begin; i < end; i++) {
					chunk[j++] = ids[i];
				}
				index = end;

				chunks.add(chunk);
			}
		}

		return chunks;
	}


	
	public static boolean isEmpty(String stringVal){
		return stringVal==null || stringVal.isEmpty()? true : false;
	}

}
