package com.techelevator.capstone.model.weatherDay;

public class WeatherDay {
	private int low;
	private int high;
	private String forecast;
	private int fiveDayForecastValue;
	private String parkCode;



	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public int getFiveDayForcastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForcastValue(int fiveDayForcastValue) {
		this.fiveDayForecastValue = fiveDayForcastValue;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

//	public double convertLowToCelcius() {
//		double lowC = ((low - 32) / 1.8);
//		return lowC;
//
//	}
//
//	public double convertHighToCelcius() {
//		double highC = ((high - 32) / 1.8);
//		return highC;
//
//	}
}
