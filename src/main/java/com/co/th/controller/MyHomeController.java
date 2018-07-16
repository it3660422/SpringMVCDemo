package com.co.th.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Model.DbCon;
import Model.UsersDto;

@Controller
public class MyHomeController {
 @RequestMapping(value ="/",method = RequestMethod.GET)
 public ModelAndView myHome () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("my-home");
		mav.addObject("title", "xx");
		mav.addObject("msg", "Testss");
		Connection con = new DbCon().con();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			ArrayList<UsersDto> lst = new ArrayList<UsersDto>();
			UsersDto a = new UsersDto();
			while (rs.next()) {
				a = new UsersDto();
				a.setName(rs.getString("name"));
				lst.add(a);
			}
			mav.addObject("title", lst.get(0).getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return mav;
 }
 @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		mav.addObject("title", name);
		mav.addObject("msg", "Testss");		
		return mav;

	}
}


