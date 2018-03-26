package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.capstone.model.park.Park;
import com.techelevator.capstone.model.park.ParkJDBCDao;


public class ParkDaoTest extends DAOIntegrationTest {

	private ParkJDBCDao testPark;
	private String newParkCode;

	
	@Before
	public void setUp() throws Exception {
		testPark = new ParkJDBCDao(getDataSource());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		String sqlParkIns = ("INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode");
		newParkCode = jdbcTemplate.queryForObject(sqlParkIns, String.class, "AAA", "ParkName", "AA", 20, 21, 22.0, 23, "hot",  2000, 12, "cool", "coolio", "neat", 15, 2);
		
	}
	@Test
	public void testAllParks() {
		List<Park> parkInfo = testPark.getAllParks();
		for(Park p : parkInfo) {
			if(p.getParkCode().contentEquals(newParkCode)){
				assertEquals(newParkCode, p.getParkCode());
				assertEquals("ParkName", p.getParkName());
				assertEquals("hot", p.getClimate());
				assertEquals(20, p.getAcreage());


				return;
			}
		}
		fail("Test Park was not found");
	}


}


