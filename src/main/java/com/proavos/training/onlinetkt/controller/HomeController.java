package com.proavos.training.onlinetkt.controller;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proavos.training.onlinetkt.service.SearchAndBookService;

@Controller
@RequestMapping({"/home"})
public class HomeController {

	private static final String HOME_VIEW = "home";
	String echoResponse;

    @EJB
    private SearchAndBookService searchAndBookService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleHomePage(HttpServletRequest request) {
		ModelAndView homeModelAndView = new ModelAndView(HOME_VIEW);
		echoResponse = searchAndBookService.echo("Hello");
		System.out.println(echoResponse);
		homeModelAndView.addObject("echoResponse", echoResponse);
		return homeModelAndView;
	}
}
