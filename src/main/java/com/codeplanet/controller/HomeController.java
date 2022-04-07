package com.codeplanet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codepanet.model.Task;

@Controller
public class HomeController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/todo")
	public String xyz() {
      return "home";
	}
	@GetMapping("/edit")
	public String edit(HttpServletRequest req, Task task) {
		req.setAttribute("task", task);
		return "edit";
	}
	@GetMapping("/inserttask")
	public String inserttask(HttpServletRequest req,Task task) throws ClassNotFoundException, SQLException {
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); //1 
		 * Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp",
		 * "test","Admin123@"); //2
		 */      
	  Connection con = jdbcTemplate.getDataSource().getConnection();
	  String desc = req.getParameter("todoitemdesc");
	  
		/*
		 * String query = "insert into task values('"+ todoitem + "')"; 
		 * Statement stmt = con.createStatement(); //3 
		 * int i = stmt.executeUpdate(query); /
		 */
	  String query = "insert into newtask(task,task_desc) values(?,?)";
	  PreparedStatement ps = con.prepareStatement(query);
		/* CallableStatement ps = con.prepareCall("call sp(?,?)"); */

	  ps.setString(1, task.getTask());
	  ps.setString(2, task.getTaskDesc());
      int i = ps.executeUpdate(); //5
      String query1= "select * from newtask";
      PreparedStatement ps1 = con.prepareStatement(query1);
      ResultSet rs = ps1.executeQuery();
      List l = new ArrayList();
      while (rs.next()) {
//    	  Map m = new HashMap();
//    	  m.put("task", rs.getString("task"));
//    	  m.put("id", rs.getInt("id"));
//    	  m.put("taskDesc", rs.getString("task_desc"));
    	  Task t = new Task();
    	  t.setId(rs.getInt("id"));
    	  t.setTask(rs.getString("task"));
    	  t.setTaskDesc(rs.getString("task_desc"));
    	  l.add(t);
      }
      req.setAttribute("list", l);
	  return "next";
	}

	
	@GetMapping("/createTask")
	public String createTask(HttpServletRequest req, HttpServletResponse res, String test) {
	String test1 = req.getParameter("test");
	String test2 = req.getParameter("test2");
	
	List l = new ArrayList();
	
	Map m = new HashMap();
	m.put("m1", "abc");
	m.put("m2", "pqr");
	l.add(m);
	
	m = new HashMap();
	m.put("m1", "tuv");
	m.put("m2", "wxy");
	l.add(m);

	m = new HashMap();
	m.put("m1", "xyz");
	m.put("m2", "efg");
	l.add(m);
	m = new HashMap();
	m.put("m1", "code");
	m.put("m2", "planet");
	l.add(m);
	
	req.setAttribute("list", l);
     return "next";
	}
	

}
