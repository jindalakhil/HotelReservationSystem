package com.capg.dto;

import org.junit.Assert;
import org.junit.Test;

public class HotelStructureTest {
	HotelStructure testHotel = new HotelStructure("TestHotel",111);
	@Test
	public void get_Hotel_Name_Meathod_Test() {
		Assert.assertEquals("TestHotel", testHotel.getHotelName());
	}
	
	@Test
	public void get_Hotel_Rate_For_Regular_Customer_Meathod_Test() {
		Assert.assertEquals(111, testHotel.getHotelRateForRegularCustomers());
	}
	
	@Test
	public void set_Hotel_Rate_For_Regular_Customer_Meathod_Test() {
		testHotel.setHotelRateForRegularCustomers(123);
		Assert.assertEquals(123, testHotel.getHotelRateForRegularCustomers());
	}
	
	@Test
	public void set_Hotel_Name_Meathod_Test() {
		testHotel.setHotelName("testHotel1");
		Assert.assertEquals("testHotel1", testHotel.getHotelName());
	}
}
