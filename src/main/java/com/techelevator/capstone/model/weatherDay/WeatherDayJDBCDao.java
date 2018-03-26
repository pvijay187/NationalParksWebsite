package com.techelevator.capstone.model.weatherDay;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class WeatherDayJDBCDao implements WeatherDayDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WeatherDayJDBCDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<WeatherDay> getWeeklyWeather(String parkCode) {
		List<WeatherDay> weatherWeek = new ArrayList<>();
		String sqlSelectWeatherWeek = "Select * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherWeek, parkCode);
		while (results.next()) {
			WeatherDay wD = new WeatherDay();
			wD.setFiveDayForcastValue(results.getInt("fivedayforecastvalue"));
			wD.setForecast(results.getString("forecast"));
			wD.setParkCode(results.getString("parkcode"));
			wD.setLow(results.getInt("low"));
			wD.setHigh(results.getInt("high"));
			weatherWeek.add(wD);
		}

		return weatherWeek;
	}

}
