package com.capg.service.impl;

import java.util.ArrayList;

import com.capg.dto.*;
import com.capg.service.HotelService;

public class HotelServiceImpl implements HotelService{
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
	
}