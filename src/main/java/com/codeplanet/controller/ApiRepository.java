package com.codeplanet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.codepanet.model.Task;

@Repository
public class ApiRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List getFirstApiData(HttpServletRequest req) throws SQLException {
		Connection con = jdbcTemplate.getDataSource().getConnection();
		String query1= "select * from newtask";
	      PreparedStatement ps1 = con.prepareStatement(query1);
	      ResultSet rs = ps1.executeQuery();
	      List l = new ArrayList();
	      while (rs.next()) {
	    	  Task t = new Task();
	    	  t.setId(rs.getInt("id"));
	    	  t.setTask(rs.getString("task"));
	    	  t.setTaskDesc(rs.getString("task_desc"));
	    	  l.add(t);
	      }
		return l;
	}

}
