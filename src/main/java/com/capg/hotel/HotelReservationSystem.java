package com.capg.hotel;

import com.capg.dto.*;
import com.capg.service.impl.*;

public class HotelReservationSystem {
	public static void main(String[] args) {
		System.out.println("Welcom to Hotel Reservation System");
		HotelStructure lakewoodHotel = new HotelStructure("Lakewood", 110);
		HotelStructure bridgewoodHotel = new HotelStructure("Bridgewood", 160);
		HotelStructure ridgewoodHotel = new HotelStructure("Ridgewood", 220);
		HotelServiceImpl obj = new HotelServiceImpl();
		obj.addHotelinList(lakewoodHotel);
		obj.addHotelinList(ridgewoodHotel);
		obj.addHotelinList(bridgewoodHotel);
		obj.showHotelList();
	}
}
