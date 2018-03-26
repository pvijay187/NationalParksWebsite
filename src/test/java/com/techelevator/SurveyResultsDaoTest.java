package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.capstone.model.park.Park;
import com.techelevator.capstone.model.survey.Survey;
import com.techelevator.capstone.model.survey.SurveyDao;
import com.techelevator.capstone.model.survey.SurveyJDBCDao;
import com.techelevator.capstone.model.survey.SurveyResults;
import com.techelevator.capstone.model.survey.SurveyResultsDao;

public class SurveyResultsDaoTest extends DAOIntegrationTest {
	private SurveyJDBCDao testSurvey;
	private SurveyDao surveyDao;
	private SurveyResultsDao surveyResultsDao;

	@Before
	public void setUp() throws Exception {
		Survey survey = new Survey();
		Survey surveyTwo = new Survey();

		testSurvey = new SurveyJDBCDao(getDataSource());
		survey.setEmail("cool");
		survey.setActivityLevel("high");
		survey.setFavPark("AAA");
		survey.setState("OH");

		surveyTwo.setEmail("hot");
		surveyTwo.setActivityLevel("low");
		surveyTwo.setFavPark("AAA");
		surveyTwo.setState("OH");
	

		testSurvey.save(survey);
		testSurvey.save(surveyTwo);

	}

	@Test
	public void testAllResults() {
		List<SurveyResults> surveyResults = testSurvey.getAllResults();
		for (SurveyResults sR : surveyResults) {
			assertEquals(2, sR.getCounter());
		} fail("Test Park was not found");

	} 
}

	


