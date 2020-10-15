package com.capg.service.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.capg.dto.HotelStructure;
import java.util.List;

public class HotelServiceImplTest {
	HotelStructure hotel1 = new HotelStructure("hotel1", 1,3);
	HotelStructure hotel2 = new HotelStructure("hotel2", 2,5);
	HotelServiceImpl obj = new HotelServiceImpl();
	
	@Test
	public void test_Add_Hotel_In_HotelList_Meathod() {
		obj.addHotelinList(hotel1);
		obj.addHotelinList(hotel2);
		//obj.showHotelList();
		ArrayList<HotelStructure> test = new ArrayList<HotelStructure>();
		test.add(hotel1);
		test.add(hotel2);
		Assert.assertEquals(test, obj.hotelList);
	}
	
	@Test
	public void find_Chepest_Hotel_Test() {
		obj.addHotelinList(hotel1);
		obj.addHotelinList(hotel2);
		String result = obj.findCheapestHotelForGivenRageOfDates("12-3-2020", "12-4-2020");
		//System.out.println(result);
		Assert.assertEquals(result, "hotel1");
	}
	
	@Test
	public void find_Chepest_Hotel_Test_Include_Weekdays_And_Weekend_Rates() {
		HotelStructure lakewoodHotel = new HotelStructure("Lakewood", 110, 90);
		HotelStructure bridgewoodHotel = new HotelStructure("Bridgewood", 150, 50);
		HotelStructure ridgewoodHotel = new HotelStructure("Ridgewood", 220, 150);
		lakewoodHotel.setHotelRating(3);
		bridgewoodHotel.setHotelRating(4);
		ridgewoodHotel.setHotelRating(5);
		HotelServiceImpl obj1 = new HotelServiceImpl();
		obj1.addHotelinList(lakewoodHotel);
		obj1.addHotelinList(ridgewoodHotel);
		obj1.addHotelinList(bridgewoodHotel);
		HotelStructure result = obj1.findCheapestHotelForGivenRageOfDatesIncludeWeekendsAndWeekdaysRate("11-09-2020", "12-09-2020");
		System.out.println(result);
		Assert.assertEquals(result, bridgewoodHotel);
	}
	
}
