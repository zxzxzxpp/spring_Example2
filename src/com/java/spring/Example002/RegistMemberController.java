package com.java.spring.Example002;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist.do")
public class RegistMemberController {

	private String formViewName = "Example002/registMemberForm";
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(Model model){
		referenceData(model);
		return formViewName;
	}
	
	private void referenceData(Model model){
		List<Code> jobCodes = new ArrayList<Code>();
		jobCodes.add(new Code("1","������"));
		jobCodes.add(new Code("2","UI ������"));
		jobCodes.add(new Code("3","�� �����̳�"));
		jobCodes.add(new Code("4","��ȹ��"));

		String[] favoritesOsNames = { "������XP", "��Ÿ", "������7", "�����", "��" };
		String[] tools = { "Eclipse", "IntelliJ", "NetBeans" };

		model.addAttribute("jobCodes", jobCodes);
		model.addAttribute("favoritesOsNames", favoritesOsNames);
		model.addAttribute("tools", tools);
	}
	
	@ModelAttribute
	protected Object formBackingObject() throws Exception{
		return new MemberInfo();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo,BindingResult result , Model model){
		
		new MemberInfoValidator().validate(memberInfo , result);
		
		checkDuplicateId(memberInfo.getUserId() , result);
		
		if(result.hasErrors()){
			referenceData(model);
			return formViewName;
		}
		return "Example002/registMember";
	}
	
	private void checkDuplicateId(String userId, BindingResult errors){
		if(userId.equals("madvirus")){
			errors.rejectValue("userId", "duplicate");
		}
	}
	
}
