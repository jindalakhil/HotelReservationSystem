package com.capg.dto;

public class HotelStructure {
	private String hotelName;
	private int hotelRateForRegularCustomersOnWeekDays;
	private int hotelRateForRegularCustomersOnWeekends;
	private int hotelRateForRewardCustomersOnWeekDays;
	private int hotelRateForRewardCustomersOnWeekends;
	private int hotelRating;
	
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

	public int getHotelRating() {
		return hotelRating;
	}

	public int getHotelRateForRewardCustomersOnWeekDays() {
		return hotelRateForRewardCustomersOnWeekDays;
	}

	public void setHotelRateForRewardCustomersOnWeekDays(int hotelRateForRewardCustomersOnWeekDays) {
		this.hotelRateForRewardCustomersOnWeekDays = hotelRateForRewardCustomersOnWeekDays;
	}

	public int getHotelRateForRewardCustomersOnWeekends() {
		return hotelRateForRewardCustomersOnWeekends;
	}

	public void setHotelRateForRewardCustomersOnWeekends(int hotelRateForRewardCustomersOnWeekends) {
		this.hotelRateForRewardCustomersOnWeekends = hotelRateForRewardCustomersOnWeekends;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
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
				+ hotelRateForRegularCustomersOnWeekends + ", hotelRateForRewardCustomersOnWeekDays="
				+ hotelRateForRewardCustomersOnWeekDays + ", hotelRateForRewardCustomersOnWeekends="
				+ hotelRateForRewardCustomersOnWeekends + ", hotelRating=" + hotelRating + "]";
	}	
}