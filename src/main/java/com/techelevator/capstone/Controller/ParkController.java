package com.techelevator.capstone.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.capstone.model.park.Park;
import com.techelevator.capstone.model.park.ParkDao;
import com.techelevator.capstone.model.weatherDay.WeatherDay;
import com.techelevator.capstone.model.weatherDay.WeatherDayDao;

@Controller
public class ParkController {

	@Autowired
	ParkDao parkDao;

	@Autowired
	WeatherDayDao weatherDayDao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showAllParks(ModelMap modelMap) {
		modelMap.put("allParks", parkDao.getAllParks());
		return "homePage";

	}

	@RequestMapping(path = "/parkDetails", method = RequestMethod.GET)
	public String showParkDetails(@RequestParam String parkCode, ModelMap modelHolder) {
		List<WeatherDay> weatherWeek = new ArrayList<>();
		for (Park park : parkDao.getAllParks()) {
			if (park.getParkCode().equals(parkCode)) {
				weatherWeek = weatherDayDao.getWeeklyWeather(parkCode);
			modelHolder.put("park", park);
			modelHolder.put("weatherWeek", weatherWeek);

		}
		
	}return "parkDetails";
	}
	@RequestMapping(path = "/parkDetails", method = RequestMethod.POST)
	public String showParkDetailsCelc(HttpSession session, @RequestParam String parkCode,
			@RequestParam boolean tempConv,  ModelMap modelHolder) {
		Boolean isFahr = true;
		if (tempConv == true) {
			isFahr = true; 
		} else {
			isFahr = false;
		}

		modelHolder.put("parkCode", parkCode);
		session.setAttribute("isFahr", isFahr);

	
	return"redirect:/parkDetails";
} }
// @RequestMapping(path = "/parkDetails", method = RequestMethod.GET)
// public String showWeatherWeek(@RequestParam String parkCode, ModelMap
// modelHolder) {
// for (WeatherDay wD : weatherDayDao.getWeeklyWeather(parkCode)) {
// if (wD.getParkCode().equals(parkCode))
// modelHolder.put("weatherDay", wD);
//
// }
// return "parkDetails";
//
// }
// }

//
// System.out.print("Please enter the temperature: ");
// String tempInput = userInput.nextLine();
// int temp = Integer.parseInt(tempInput);
//
// System.out.print("Is the temperature in (C)elcius, or (F)arenheit?: ");
// String scaleInput = userInput.nextLine();
//
// if("F".equals(scaleInput)) {
// int celciusTemp = (int)((temp - 32) / 1.8);
// System.out.println(temp+"F is "+celciusTemp+"C.");
// } else if("C".equals(scaleInput)) {
// int fahrenheitTemp = (int)((temp * 1.8) + 32);
// System.out.println(temp+"C is "+fahrenheitTemp+"F.");
// } else {
// System.out.println(scaleInput+" is an invalid choice.");
