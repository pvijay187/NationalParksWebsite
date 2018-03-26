package com.techelevator.capstone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.capstone.model.survey.Survey;
import com.techelevator.capstone.model.survey.SurveyDao;
import com.techelevator.capstone.model.survey.SurveyResults;
import com.techelevator.capstone.model.survey.SurveyResultsDao;

@Controller
public class SurveyController {
	@Autowired
	SurveyDao surveyDao;

	@Autowired
	SurveyResultsDao surveyResultsDao;

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String displaySurveyPage() {
		return "survey";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String showSurvey(@RequestParam String parkCode, @RequestParam String email, @RequestParam String state,
			@RequestParam String activityLevel) {
		Survey survey = new Survey();
		survey.setState(state);
		survey.setFavPark(parkCode);
		survey.setEmail(email);
		survey.setActivityLevel(activityLevel);
		surveyDao.save(survey);
		
		return "redirect:/surveyList";

	}

	@RequestMapping(path="/surveyList", method = RequestMethod.GET)
	public String showSurveyList(ModelMap modelMap) {
		List<SurveyResults> surveyResults = surveyResultsDao.getAllResults();
		modelMap.put("surveyResults", surveyResults);
		return "surveyList";
	}	
	
}
