package com.techelevator.capstone.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class SurveyJDBCDao implements SurveyDao, SurveyResultsDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
		public SurveyJDBCDao(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}


	@Override
	public void save(Survey survey) {
		Long id = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getFavPark(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		survey.setId(id);
		
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}

	@Override
	public List<SurveyResults> getAllResults() {
		List<SurveyResults> allResults = new ArrayList<>();
		String sqlSelectSurveyResults = "SELECT count(*) AS votecount, parkcode FROM survey_result "
				+ "GROUP BY parkcode "
				+ "ORDER BY votecount DESC, parkcode ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSurveyResults);
		while(results.next()) {
			SurveyResults sR = new SurveyResults();
			sR.setCounter(results.getInt("votecount"));
			sR.setParkName(results.getString("parkcode"));
			allResults.add(sR);
		}
		
		return allResults;
	}
}
