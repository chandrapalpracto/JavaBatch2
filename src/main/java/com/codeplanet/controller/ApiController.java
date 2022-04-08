package com.codeplanet.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	
	@Autowired
	ApiService apiService;

	@GetMapping("/firstApi")
	public List getFirstApiData(HttpServletRequest req) throws SQLException {
		List list = apiService.getFirstApiData(req);
		return list;
	}

}
