package com.capg.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		long difference_In_Time = endDate.getTime() - startDate.getTime();
		return (difference_In_Time / (1000 * 60 * 60 * 24));
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
			 System.out.println(days);
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

}