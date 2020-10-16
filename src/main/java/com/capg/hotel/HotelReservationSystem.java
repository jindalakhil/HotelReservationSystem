package com.capg.hotel;

import java.util.Scanner;

import com.capg.dto.*;
import com.capg.exception.InvalidCustomerTypeException;
import com.capg.service.impl.*;

public class HotelReservationSystem {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcom to Hotel Reservation System");
		HotelStructure lakewoodHotel = new HotelStructure("Lakewood", 110, 90);
		HotelStructure bridgewoodHotel = new HotelStructure("Bridgewood", 150, 50);
		HotelStructure ridgewoodHotel = new HotelStructure("Ridgewood", 220, 150);
		HotelServiceImpl obj = new HotelServiceImpl();
		obj.addHotelinList(lakewoodHotel);
		obj.addHotelinList(ridgewoodHotel);
		obj.addHotelinList(bridgewoodHotel);
		lakewoodHotel.setHotelRateForRewardCustomersOnWeekDays(80);
		lakewoodHotel.setHotelRateForRewardCustomersOnWeekends(80);
		bridgewoodHotel.setHotelRateForRewardCustomersOnWeekDays(110);
		bridgewoodHotel.setHotelRateForRewardCustomersOnWeekends(50);
		ridgewoodHotel.setHotelRateForRewardCustomersOnWeekDays(100);
		ridgewoodHotel.setHotelRateForRewardCustomersOnWeekends(40);
		lakewoodHotel.setHotelRating(3);
		bridgewoodHotel.setHotelRating(4);
		ridgewoodHotel.setHotelRating(5);
		obj.showHotelList();

		try {
			System.out.println("Enter start date in format dd-MM-yyyy");
			String start = sc.nextLine();
			System.out.println("Enter the end date in format dd-MM-yyyy");
			String end = sc.nextLine();
			System.out.println("Enter the Customer type: Regular or Reward");
			String customerType = sc.nextLine();
			if (!(customerType.equalsIgnoreCase("regular") || customerType.equalsIgnoreCase("reward"))) {
				throw new InvalidCustomerTypeException();
			}
			if (customerType.equalsIgnoreCase("regular"))
				System.out.println("Cheapest Hotel Is: "
						+ obj.findCheapestHotelForGivenRageOfDatesIncludeWeekendsAndWeekdaysRate(start, end));
			else if (customerType.equalsIgnoreCase("reward"))
				System.out.println("Cheapest Hotel Is: "
						+ obj.findCheapestBestRatedHotelForGivenRageOfDatesForRewardCustomers(start, end));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
