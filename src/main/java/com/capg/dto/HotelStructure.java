package com.capg.dto;

public class HotelStructure {
	private String hotelName;
	private int hotelRateForRegularCustomers;
	
	public HotelStructure(String hotelName, int hotelRateForRegularCustomers) {
		super();
		this.hotelName = hotelName;
		this.hotelRateForRegularCustomers = hotelRateForRegularCustomers;
	}
	
	public HotelStructure() {}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelRateForRegularCustomers() {
		return hotelRateForRegularCustomers;
	}

	public void setHotelRateForRegularCustomers(int hotelRateForRegularCustomers) {
		this.hotelRateForRegularCustomers = hotelRateForRegularCustomers;
	}

	@Override
	public String toString() {
		return "HotelStructure [hotelName=" + hotelName + ", hotelRateForRegularCustomers="
				+ hotelRateForRegularCustomers + "]";
	}
	
	
}