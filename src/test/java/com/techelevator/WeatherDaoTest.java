package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.capstone.model.park.ParkJDBCDao;
import com.techelevator.capstone.model.weatherDay.WeatherDay;
import com.techelevator.capstone.model.weatherDay.WeatherDayJDBCDao;

public class WeatherDaoTest extends DAOIntegrationTest {

	private WeatherDayJDBCDao weatherDay;
	private String newParkCode;
	private ParkJDBCDao testPark;


	@Before
	public void setUp() throws Exception {
		weatherDay = new WeatherDayJDBCDao(getDataSource());
		testPark = new ParkJDBCDao(getDataSource());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		
		String sqlParkIns = ("INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode");
		newParkCode = jdbcTemplate.queryForObject(sqlParkIns, String.class, "AAA", "ParkName", "AA", 20, 21, 22.0, 23, "hot",  2000, 12, "cool", "coolio", "neat", 15, 2);
		
		

		String sqlWeatherIn = ("INSERT INTO weather(parkcode, fivedayforecastvalue, low, high, forecast)"
				+ "VALUES(?,?,?,?,?) RETURNING parkcode");
		newParkCode = jdbcTemplate.queryForObject(sqlWeatherIn, String.class, "AAA", 2, 5, 10, "hot");
	}

	@Test
	public void testAllParks() {
		List<WeatherDay> weatherInfo = weatherDay.getWeeklyWeather(newParkCode);
		for (WeatherDay wD : weatherInfo) {
			if (wD.getParkCode().contentEquals(newParkCode))
				assertEquals(newParkCode, wD.getParkCode());
			assertEquals("hot", wD.getForecast());
			return;
		} fail("Test Weather was not found");
	}

}
