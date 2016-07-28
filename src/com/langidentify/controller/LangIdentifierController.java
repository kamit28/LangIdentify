package com.langidentify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.langidentify.model.Content;
import com.langidentify.service.LangIdentifierService;

@Controller
public class LangIdentifierController {
	@Autowired
	private LangIdentifierService langIdentifierService;

	@RequestMapping(value = "/identify", method = RequestMethod.POST)
	public String identify(@ModelAttribute("SpringWeb") Content content,
			ModelMap model) throws Exception {

		String result = langIdentifierService.identify(content);
		model.addAttribute("result", result);
		return "result";
	}

	@RequestMapping(value = "/newform", method = RequestMethod.GET)
	public ModelAndView newform(Model model) throws Exception {
		model.addAttribute("content", new Content());
		return new ModelAndView("user_input", "command", new Content());
	}
}
