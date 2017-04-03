package com.java.spring.Example004;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LocaleChangeController {

	private LocaleResolver localeResolver;
	
	@RequestMapping("/changeLanguage")
	public String change(@RequestParam("lang")String language, HttpServletRequest request , HttpServletResponse response){
		
		Locale locale = new Locale(language);
		localeResolver.setLocale(request,response, locale);
		return "redirect:index.jsp";
	}

	@RequestMapping("/index")
	public String form()
	{
		return "index";
	}
	
	public void setLocaleResolver(LocaleResolver localeResolver){
		this.localeResolver= localeResolver;
	}
}
