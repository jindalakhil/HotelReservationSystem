package com.capg.dto;

import org.junit.Assert;
import org.junit.Test;

public class HotelStructureTest {
	HotelStructure testHotel = new HotelStructure("TestHotel",111,12);
	@Test
	public void get_Hotel_Name_Meathod_Test() {
		Assert.assertEquals("TestHotel", testHotel.getHotelName());
	}
	
	@Test
	public void get_Hotel_Rate_For_Regular_Customer_WeekDays_Meathod_Test() {
		Assert.assertEquals(111, testHotel.getHotelRateForRegularCustomersOnWeekDays());
	}
	
	@Test
	public void set_Hotel_Rate_For_Regular_Customer_WeekDays_Meathod_Test() {
		testHotel.setHotelRateForRegularCustomersOnWeekDays(123);
		Assert.assertEquals(123, testHotel.getHotelRateForRegularCustomersOnWeekDays());
	}
	
	@Test
	public void set_Hotel_Name_Meathod_Test() {
		testHotel.setHotelName("testHotel1");
		Assert.assertEquals("testHotel1", testHotel.getHotelName());
	}
	
	@Test
	public void get_Hotel_Rate_For_Regular_Customer_Weekends_Meathod_Test() {
		Assert.assertEquals(12, testHotel.getHotelRateForRegularCustomersOnWeekends());
	}
	
	@Test
	public void set_Hotel_Rate_For_Regular_Customer_Weekends_Meathod_Test() {
		testHotel.setHotelRateForRegularCustomersOnWeekends(1111);
		Assert.assertEquals(1111, testHotel.getHotelRateForRegularCustomersOnWeekends());
	} 
	
	@Test
	public void hotel_Rating_Meathod_Test() {
		testHotel.setHotelRating(3);
		Assert.assertEquals(3, testHotel.getHotelRating());
	}
	
	@Test
	public void set_Hotel_Rate_For_Rewards_Customer_Weekends_Meathod_Test() {
		testHotel.setHotelRateForRewardCustomersOnWeekends(112211);
		Assert.assertEquals(112211, testHotel.getHotelRateForRewardCustomersOnWeekends());
	} 
	
	@Test
	public void set_Hotel_Rate_For_Rewards_Customer_Weekendays_Meathod_Test() {
		testHotel.setHotelRateForRewardCustomersOnWeekends(111);
		Assert.assertEquals(111, testHotel.getHotelRateForRewardCustomersOnWeekends());
	} 
}
