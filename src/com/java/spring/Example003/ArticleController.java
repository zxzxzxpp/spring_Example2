package com.java.spring.Example003;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
	
	private String uri = "Example003/article/";
	
	@RequestMapping(value="/article/{id}",method=RequestMethod.GET)
	public String read(@PathVariable("id")Integer id , Model model){
		
		model.addAttribute("article",new Article(id));
		return uri+"read";
	}
	
	@RequestMapping(value="/article/{id}" , method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id , Model model){
		
		model.addAttribute("article",new Article(id));
		return uri+"delete";
	}
	
	@RequestMapping(value="/article/{id}" , method=RequestMethod.PUT)
	public String modify(@PathVariable("id")Integer id , Model model) {
		model.addAttribute("article", new Article(id));
		return uri+"modify";
	}
	
	@RequestMapping(value="/article" , method=RequestMethod.POST)
	public String write(Model model){
		model.addAttribute("article", new Article(2));
		return uri+"write";
	}
	
	@RequestMapping("/articleForm.do")
	public String testForm(Model model){
		model.addAttribute("article",new Article(1));
		return uri+"testForm";
	}
	
}
