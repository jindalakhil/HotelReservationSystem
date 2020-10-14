package com.capg.service.impl;

import org.junit.Assert;
import org.junit.Test;

import com.capg.dto.HotelStructure;

public class HotelServiceImplTest {
	@Test
	public void test_Add_Hotel_In_HotelList_Meathod() {
		HotelStructure hotel1 = new HotelStructure("hotel1", 1);
		HotelStructure hotel2 = new HotelStructure("hotel2", 2);
		HotelServiceImpl obj = new HotelServiceImpl();
		obj.addHotelinList(hotel1);
		obj.addHotelinList(hotel2);
		obj.showHotelList();
	}
}
