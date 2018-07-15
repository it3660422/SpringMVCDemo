package com.co.th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyHomeController {
 @RequestMapping(value ="/",method = RequestMethod.GET)
 public ModelAndView myHome () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xmy-home");
		mav.addObject("title", "xx");
		mav.addObject("msg", "Testss");
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


