package com.capg.dto;

public class HotelStructure {
	private String hotelName;
	private int hotelRateForRegularCustomersOnWeekDays;
	private int hotelRateForRegularCustomersOnWeekends;
	
	public HotelStructure(String hotelName, int hotelRateForRegularCustomersOnWeekDays, int hotelRateForRegularCustomersOnWeekends) {
		super();
		this.hotelName = hotelName;
		this.hotelRateForRegularCustomersOnWeekDays = hotelRateForRegularCustomersOnWeekDays;
		this.hotelRateForRegularCustomersOnWeekends = hotelRateForRegularCustomersOnWeekends;
	}
	
	public HotelStructure() {}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelRateForRegularCustomersOnWeekDays() {
		return hotelRateForRegularCustomersOnWeekDays;
	}

	public void setHotelRateForRegularCustomersOnWeekDays(int hotelRateForRegularCustomersOnWeekDays) {
		this.hotelRateForRegularCustomersOnWeekDays = hotelRateForRegularCustomersOnWeekDays;
	}

	public int getHotelRateForRegularCustomersOnWeekends() {
		return hotelRateForRegularCustomersOnWeekends;
	}

	public void setHotelRateForRegularCustomersOnWeekends(int hotelRateForRegularCustomersOnWeekends) {
		this.hotelRateForRegularCustomersOnWeekends = hotelRateForRegularCustomersOnWeekends;
	}

	@Override
	public String toString() {
		return "HotelStructure [hotelName=" + hotelName + ", hotelRateForRegularCustomersOnWeekDays="
				+ hotelRateForRegularCustomersOnWeekDays + ", hotelRateForRegularCustomersOnWeekends="
				+ hotelRateForRegularCustomersOnWeekends + "]";
	}
	
}