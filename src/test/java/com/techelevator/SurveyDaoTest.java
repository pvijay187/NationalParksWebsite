package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.capstone.model.park.ParkJDBCDao;
import com.techelevator.capstone.model.survey.Survey;
import com.techelevator.capstone.model.survey.SurveyDao;
import com.techelevator.capstone.model.survey.SurveyJDBCDao;
import com.techelevator.capstone.model.weatherDay.WeatherDay;

public class SurveyDaoTest extends DAOIntegrationTest {
	private SurveyJDBCDao testSurvey;
	

	@Before
	public void setUp() throws Exception {
		Survey survey = new Survey();
		testSurvey = new SurveyJDBCDao(getDataSource());
		survey.setEmail("cool");
		survey.setActivityLevel("high");
		survey.setFavPark("AAA");
		survey.setState("OH");
		testSurvey.save(survey);
		
	

	}

	@Test
	public void save() {
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String sqlSelectAllSurvey = "SELECT state FROM survey_result WHERE state = 'OH'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurvey);
		results.next();
		assertEquals("OH", results.getString("state"));

		

	}

}
