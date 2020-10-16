package com.capg.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
			for (HotelStructure hotel : hotelList) {
				long rate = hotel.getHotelRateForRegularCustomersOnWeekDays() * days;
				if (rate < min) {
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
		if (startDate.after(endDate)) {
			Date temp = endDate;
			endDate = startDate;
			startDate = temp;
		}
		long count = 0;
		while (startDate.before(endDate) || startDate.equals(endDate)) {
			if (startDate.getDay() == 0 || startDate.getDay() == 6) {
				count++;
			}
			Date nextDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24));
			startDate = nextDate;
		}
		return count;
	}

	public HotelStructure findCheapestHotelForGivenRageOfDatesIncludeWeekendsAndWeekdaysRate(String startDate,
			String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start;
		Date end;
		long minRate = Long.MAX_VALUE;
		try {
			start = formatter.parse(startDate);
			end = formatter.parse(endDate);
			System.out.println(start);
			System.out.println(end);
			long totalDays = numberOfDaysCalculator(start, end);
			long weekends = numberOfWeekendDaysCalculator(start, end);
			long weekDays = totalDays - weekends;
			int rating = 0;
			HotelStructure hotelResult = null;
			minRate = hotelList.stream()
					.map(n -> n.getHotelRateForRegularCustomersOnWeekDays() * weekDays
							+ n.getHotelRateForRegularCustomersOnWeekends() * weekDays)
					.sorted().findFirst().orElse(null);
			long minStream = minRate;

			List<HotelStructure> minHotelList = hotelList.stream()
					.filter(n -> (n.getHotelRateForRegularCustomersOnWeekDays() * weekDays
							+ n.getHotelRateForRegularCustomersOnWeekends() * weekDays) == minStream)
					.collect(Collectors.toList());

			hotelResult = minHotelList.stream().max(Comparator.comparing(HotelStructure::getHotelRating)).orElse(null);

			System.out.println("Total rates: " + minRate);
			return hotelResult;
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public HotelStructure findBestRatedHotelForGivenRageOfDates(String startDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start;
		Date end;
		try {
			start = formatter.parse(startDate);
			end = formatter.parse(endDate);
			long totalDays = numberOfDaysCalculator(start, end);
			long weekends = numberOfWeekendDaysCalculator(start, end);
			long weekDays = totalDays - weekends;
			int rating = 0;
			HotelStructure result = hotelList.stream()
					.sorted(Comparator.comparing(HotelStructure::getHotelRating).reversed()).findFirst().orElse(null);
			long rate = (result.getHotelRateForRegularCustomersOnWeekDays() * weekDays)
					+ (result.getHotelRateForRegularCustomersOnWeekends() * weekends);
			System.out.println("Total rates:" + rate);
			return result;
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public HotelStructure findCheapestBestRatedHotelForGivenRageOfDatesForRewardCustomers(String startDate,
			String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start;
		Date end;
		long minRate = Long.MAX_VALUE;
		try {
			start = formatter.parse(startDate);
			end = formatter.parse(endDate);
			System.out.println(start);
			System.out.println(end);
			long totalDays = numberOfDaysCalculator(start, end);
			long weekends = numberOfWeekendDaysCalculator(start, end);
			long weekDays = totalDays - weekends;
			int rating = 0;
			HotelStructure hotelResult = null;

			minRate = hotelList.stream()
					.map(n -> n.getHotelRateForRewardCustomersOnWeekDays() * weekDays
							+ n.getHotelRateForRewardCustomersOnWeekends() * weekDays)
					.sorted().findFirst().orElse(null);
			long minStream = minRate;

			List<HotelStructure> minHotelList = hotelList.stream()
					.filter(n -> (n.getHotelRateForRewardCustomersOnWeekDays() * weekDays
							+ n.getHotelRateForRewardCustomersOnWeekends() * weekDays) == minStream)
					.collect(Collectors.toList());

			hotelResult = minHotelList.stream().max(Comparator.comparing(HotelStructure::getHotelRating)).orElse(null);

			System.out.println("Total rates: " + minRate);
			return hotelResult;
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return null;
	}

}