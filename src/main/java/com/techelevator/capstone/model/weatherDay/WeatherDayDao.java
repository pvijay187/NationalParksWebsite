package com.techelevator.capstone.model.weatherDay;

import java.util.List;

public interface WeatherDayDao {

	public List<WeatherDay> getWeeklyWeather(String parkCode);
}
