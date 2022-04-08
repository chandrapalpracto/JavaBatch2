package com.codeplanet.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

	@Autowired
	ApiRepository apiRepository;
	public List getFirstApiData(HttpServletRequest req) throws SQLException {
		List list = apiRepository.getFirstApiData(req);
		return list;
	}

}
