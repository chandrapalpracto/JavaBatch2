package com.codeplanet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/todo")
	public String xyz() {
      return "home";
	}
	
	@GetMapping("/inserttask")
	public String inserttask(String todoitem) throws ClassNotFoundException, SQLException {
	  System.out.println(todoitem);
	  Class.forName("com.mysql.jdbc.Driver"); //1
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapp",
			  "test","Admin123@"); //2
      Statement stmt = con.createStatement(); //3
      String query = "insert into task values('"+ todoitem + "')";
      int i = stmt.executeUpdate(query); //5
      System.out.print(i);
      
	  return "todo";
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
