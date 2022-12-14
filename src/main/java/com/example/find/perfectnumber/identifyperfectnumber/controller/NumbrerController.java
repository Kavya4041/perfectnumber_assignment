package com.example.find.perfectnumber.identifyperfectnumber.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.find.perfectnumber.identifyperfectnumber.service.ServiceNumber;

@RestController
public class NumbrerController {
	
	@Autowired
	ServiceNumber serviceNumber;
	
	//Checks if a given number is perfect or not.
	@GetMapping("/checkperfectnumbers")
	public String checkSinglenumber(@RequestParam(required = true) Integer startrange) {

		if (startrange > 0) {
			if (serviceNumber.findperfectnumber(startrange)) {
				return startrange + " is a Perfect number";
			} else {
				return startrange + " is not a Perfect number";
			}
		} else {
			return "Please enter value more than 0";
		}

	}
    
	//Finds all perfect numbers between a range (start-end)
	@GetMapping("/checkrange")
	public String checkrange(@RequestParam(required = true) Integer startrange,
			@RequestParam(required = true) Integer endrange) {
		if (startrange > 0 && endrange > 0) {

			List<Integer> list = new ArrayList<>();

			for (int j = startrange; j <= endrange; j++) {
				if (serviceNumber.findperfectnumber(j)) {
					list.add(j);
				}
			}
			if (list.size() > 0) {
				return list.toString();
			}

			return "No perfect numbers between " + startrange + " and " + endrange;
		} else {
			return "Please enter value more than 0";
		}

	}
	
	/*Below API will provide perfect numbers between range, 
	 * if API query parameters are two if one it will output whether the given number is perfect or not
	 */
	@Validated
	@GetMapping("/checkinsinglepath")
	public String getResult(@RequestParam(required = true) Integer startrange,
			@RequestParam("endrange") Optional<Integer> endrange) {

		if (endrange.isPresent()) {

			List<Integer> list = new ArrayList<>();

			for (int j = startrange; j <= endrange.get(); j++) {
				if (serviceNumber.findperfectnumber(j)) {
					list.add(j);
				}
			}
			if (list.size() > 0) {
				return list.toString();
			}

			return "No perfect numbers between " + startrange + " and " + endrange.get();
		} else {
			if (serviceNumber.findperfectnumber(startrange)) {
				return startrange + " is a Perfect number";
			} else {
				return startrange + " is not a Perfect number";
			}

		}
	}

}
		
	
