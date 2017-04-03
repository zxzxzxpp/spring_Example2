package com.java.spring.Example008;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/regist.do")
public class RegistMemberControllerForVelocity {

	private String formViewName = "registMemberForm";

	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		referenceData(model);
		return formViewName;
	}

	private void referenceData(Model model) {
		Map<String, String> jobCodes = new LinkedHashMap<String, String>();
		jobCodes.put("1", "������");
		jobCodes.put("2", "UI ������");
		jobCodes.put("3", "�� �����̳�");
		jobCodes.put("4", "��ȹ��");

		Map<String, String> favoritesOsNames = new LinkedHashMap<String, String>();
		favoritesOsNames.put("������XP", "������XP");
		favoritesOsNames.put("��Ÿ", "��Ÿ");
		favoritesOsNames.put("������7", "������7");
		favoritesOsNames.put("�����", "�����");
		favoritesOsNames.put("��", "��");
		
		Map<String, String> tools = new LinkedHashMap<String, String>();
		tools.put("Eclipse", "Eclipse");
		tools.put("IntelliJ", "IntelliJ");
		tools.put("NetBeans", "NetBeans");

		model.addAttribute("jobCodes", jobCodes);
		model.addAttribute("favoritesOsNames", favoritesOsNames);
		model.addAttribute("tools", tools);
	}

	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
		// MemberInfo member = new MemberInfo();
		// member.setAddress(new Address());
		// return member;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo,
			BindingResult result, Model model) {
		new MemberInfoValidator().validate(memberInfo, result);
		checkDuplicateId(memberInfo.getUserId(), result);
		if (result.hasErrors()) {
			referenceData(model);
			return formViewName;
		}
		return "registMember";
	}

	private void checkDuplicateId(String userId, BindingResult errors) {
		if (userId.equals("madvirus")) {
			errors.rejectValue("userId", "duplicate");
		}
	}

}