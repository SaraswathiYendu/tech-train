package com.strings.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeApi {
	public static void main(String[] args) {
		/* Date: LocalDate */
		
		/* Todays Date */
		System.out.println(LocalDate.now()); //2022-10-04
		
		/* Custom Date */
		String strDate="2022-10-10";
		LocalDate customld = LocalDate.parse(strDate);
		System.out.println(customld); //2022-10-10
		
		/* Utility Methods : plus/minus Day:Month:year */
		System.out.println(customld = customld.plusDays(1)); //2022-10-11
		System.out.println(customld = customld.plusMonths(1)); //2022-11-11
		System.out.println(customld = customld.minusYears(1)); //2021-11-11
		
		/* Date Comparision */
		String couponLastDate="2022-10-15";
		String offerDate="2022-10-03";
		
		boolean isAfter = LocalDate.parse(couponLastDate).isAfter(LocalDate.now());
		System.out.println(isAfter?"Coupon Valid":"Coupon Not Valid");
		
		boolean isAfter1 = LocalDate.parse(offerDate).isAfter(LocalDate.now());
		System.out.println(isAfter1?"Offer Valid":"Offer Not Valid");
		
		boolean isBefore = customld.isBefore(LocalDate.parse(couponLastDate));
		System.out.println(isBefore?"Coupon Valid":"Coupon Not Valid");
		
		/* Extract Meaningful Info from date */
		System.out.println(LocalDate.now().getDayOfWeek()); //TUESDAY
		System.out.println(LocalDate.now().getDayOfMonth()); //4
		System.out.println(LocalDate.now().getDayOfYear()); //277
		System.out.println(LocalDate.now().isLeapYear());
		
		/* Difference between dates */
		Period p = Period.between(LocalDate.parse(couponLastDate), LocalDate.now());
		System.out.println(p); //P-11D
		System.out.println(p.getDays()); //-11
		//Another Way
		long days = ChronoUnit.DAYS.between(LocalDate.parse(couponLastDate), LocalDate.now());
		System.out.println(days); //-11
		
		/* Local Time */
		
		/* Current Time */
		System.out.println(LocalTime.now());
		
		/* Custom Time */
		LocalTime customTime = LocalTime.parse("17:30"); 
		System.out.println(customTime);
		
		/* Utility Methods : PLUS/MINUS - HOURS-MINUTES*/
		System.out.println(customTime.plusHours(1)); //18.30
		
		/* Time Comparision */
		boolean isOnTime = LocalTime.parse("15:15").isBefore(LocalTime.parse("15:20"));
		System.out.println(isOnTime?"Process Order": "Decline Order");
		
		/* LocalDateTime */
		System.out.println(LocalDateTime.now()); 
		
		System.out.println(LocalDateTime.now().toString().split("T")[0]); //date
		System.out.println(LocalDateTime.now().toString().split("T")[1]); //time
	}
}











