package com.capg.hotel;

import java.util.Scanner;

import com.capg.dto.*;
import com.capg.service.impl.*;

public class HotelReservationSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcom to Hotel Reservation System");
		HotelStructure lakewoodHotel = new HotelStructure("Lakewood", 110, 90);
		HotelStructure bridgewoodHotel = new HotelStructure("Bridgewood", 150, 50);
		HotelStructure ridgewoodHotel = new HotelStructure("Ridgewood", 220, 150);
		HotelServiceImpl obj = new HotelServiceImpl();
		obj.addHotelinList(lakewoodHotel);
		obj.addHotelinList(ridgewoodHotel);
		obj.addHotelinList(bridgewoodHotel);
		obj.showHotelList();
		
		System.out.println("Enter start date in format dd-MM-yyyy");
		String start = sc.nextLine();
		System.out.println("Enter the end date in format dd-MM-yyyy");
		String end = sc.nextLine();
		System.out.println("Cheapest Hotel Is: " + obj.findCheapestHotelForGivenRageOfDatesIncludeWeekendsAndWeekdaysRate(start, end));
	}
}
