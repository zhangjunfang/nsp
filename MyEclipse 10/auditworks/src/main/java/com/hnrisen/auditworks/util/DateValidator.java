/**
 * 
 * 时间工具类
 * 
 */
package com.hnrisen.auditworks.util;

/**
 * @author ： ocean
 *  date ：2012-4-23
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateValidator {
	
	/**
	 * 
	 * 验证时间是否在某个时间段内
	 * 
	 * */
	public boolean isThisDateWithin3MonthsRange(String dateToValidate, String dateFromat, int i) {
	
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			
			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			
			// current date after 3 months
			Calendar currentDateAfter3Months = Calendar.getInstance();
			// currentDateAfter3Months.add(Calendar.MONTH, 3);
			currentDateAfter3Months.add(Calendar.MONTH, i);
			// current date before 3 months
			Calendar currentDateBefore3Months = Calendar.getInstance();
			currentDateBefore3Months.add(Calendar.MONTH, -i);
			
			/*************** verbose ***********************/
			System.out.println("\n\ncurrentDate : " + Calendar.getInstance().getTime());
			System.out.println("currentDateAfter3Months : " + currentDateAfter3Months.getTime());
			System.out.println("currentDateBefore3Months : " + currentDateBefore3Months.getTime());
			System.out.println("dateToValidate : " + dateToValidate);
			/************************************************/
			
			if (date.before(currentDateAfter3Months.getTime())
					&& date.after(currentDateBefore3Months.getTime())) {
				
				return true;
				
			} else {
				
				return false;
				
			}
			
		} catch ( ParseException e ) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 验证字符串时间 是否合法
	 * 
	 * */
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {
	
		if (dateToValidate == null) {
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		
		try {
			
			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
			
		} catch ( ParseException e ) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
