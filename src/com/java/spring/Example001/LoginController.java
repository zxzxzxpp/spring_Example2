package com.java.spring.Example001;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private Authenticator authenticator;
	
	@ModelAttribute("login")
	public LoginCommand formBacking(){
		return new LoginCommand();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		return "Example001/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("login")LoginCommand loginCommand,BindingResult result)
	{
		new LoginCommandValidator().validate(loginCommand , result);
		if(result.hasErrors())
		{
			return "Example001/loginForm";
		}
		try{
			authenticator.authenticate(loginCommand.getId(),loginCommand.getPassword());
			return "Example001/loginSuccess";
		}catch (AuthenticationException e) {
			// TODO: handle exception
			result.reject("incalidIdOrPassword" , new Object[] {loginCommand.getId()} ,null);
			return "Example001/loginForm";
		}
	}
	
	
	@ModelAttribute("loginTypes")
	protected List<String> referenceData() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("�Ϲ�ȸ��");
		loginTypes.add("���ȸ��");
		loginTypes.add("�������ȸ��");
		return loginTypes;
	}
	
	public void setAuthenticator(Authenticator authenticator)
	{
		this.authenticator=authenticator;
	}
}
