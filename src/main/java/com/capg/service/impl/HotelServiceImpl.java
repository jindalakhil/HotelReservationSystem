package com.capg.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.capg.dto.*;
import com.capg.service.HotelService;

public class HotelServiceImpl implements HotelService {
	ArrayList<HotelStructure> hotelList;

	public HotelServiceImpl() {
		hotelList = new ArrayList<>();
	}

	public void addHotelinList(HotelStructure hotel) {
		if (checkHotelExistance(hotel)) {
			System.out.println("Hotel with this name already exists");
			return;
		}
		hotelList.add(hotel);
	}

	private boolean checkHotelExistance(HotelStructure hotel) {
		return hotelList.stream().anyMatch(x -> x.getHotelName().equalsIgnoreCase(hotel.getHotelName()));
	}

	public void showHotelList() {
		hotelList.stream().forEach(x -> System.out.println(x));
	}

	private long numberOfDaysCalculator(Date startDate, Date endDate) {
		long difference_In_Time = Math.abs(endDate.getTime() - startDate.getTime());
		return (difference_In_Time / (1000 * 60 * 60 * 24)) + 1;
	}

	public String findCheapestHotelForGivenRageOfDates(String startDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start;
		Date end;
	    long min = Long.MAX_VALUE;
	    String result = null;
		try {
			 start = formatter.parse(startDate);
			 end = formatter.parse(endDate);
			 System.out.println(start);
			 System.out.println(end);
			 long days = numberOfDaysCalculator(start, end);
//			 System.out.println(days);
			 for(HotelStructure hotel : hotelList ) {
				long rate = hotel.getHotelRateForRegularCustomersOnWeekDays() * days;
				if(rate < min) {
					min = rate;
					result = hotel.getHotelName();
				}
			 }
			 System.out.println("Total rates:" + min);
			 return result;
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	private long numberOfWeekendDaysCalculator(Date startDate, Date endDate) {
		if(startDate.after(endDate)) {
			Date temp = endDate;
			endDate = startDate;
			startDate = temp;
		}
		long count =0;
		while(startDate.before(endDate) || startDate.equals(endDate)) {
			if(startDate.getDay() == 0 || startDate.getDay() == 6) {
				count++;
			}
			Date nextDate  = new Date(startDate.getTime() + (1000 * 60 * 60 * 24));
			startDate = nextDate;
		}
		return count;
	}
	
	public List<String> findCheapestHotelForGivenRageOfDatesIncludeWeekendsAndWeekdaysRate(String startDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start;
		Date end;
	    long min = Long.MAX_VALUE;
	    String result = null;
		try {
			 start = formatter.parse(startDate);
			 end = formatter.parse(endDate);
			 ArrayList<String> cheapHotelList = new ArrayList<String>();
			 System.out.println(start);
			 System.out.println(end);
			 long totalDays = numberOfDaysCalculator(start, end);
			 long weekends = numberOfWeekendDaysCalculator(start, end);
			 long weekDays = totalDays - weekends;
//			 System.out.println(totalDays);
//			 System.out.println(weekDays);
//			 System.out.println(weekends);
			 for(HotelStructure hotel : hotelList ) {
				long rate = (hotel.getHotelRateForRegularCustomersOnWeekDays() * weekDays) + (hotel.getHotelRateForRegularCustomersOnWeekends() * weekends);
				if(rate < min) {
					min = rate;
					cheapHotelList.clear();
					cheapHotelList.add(hotel.getHotelName());
				} else if(rate == min) {
					cheapHotelList.add(hotel.getHotelName());
				}
			 }
			 System.out.println("Total rates:" + min);
			 return cheapHotelList;
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return null;
	}

}