package com.yandj.springdemo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {
	final static Logger log = Logger.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// test1 : Testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test1");
		return "requestMappingAndParamResults";
	}

	// test2 : Testing @RequestParam method attributes
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test2");
		return "requestMappingAndParamResults";
	}

	// test3 : Testing @RequestParam method attributes
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public String requestMappingAndParamTest3(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test3");
		return "requestMappingAndParamResults";
	}

	// test4 : Testing fallback custom 404 page
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingAndParamTest4() {
		return "fallback";
	}

	// test5 : Testing @RequestParam default value attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(
			@RequestParam(value = "orgName", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test5");
		return "requestMappingAndParamResults";
	}

	// test6 : Testing @RequestParam without name, value attributes
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String requestMappingAndParamTest6(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6");
		return "requestMappingAndParamResults";
	}

	// test7 : Testing @RequestParam without name, value attributes
//	@RequestMapping(value = "/test7")
//	public String requestMappingAndParamTest7Subtest1(@RequestParam String orgName, Model model) {
//		model.addAttribute("orgName", orgName);
//		model.addAttribute("testSerial", "test7-subtest1");
//		return "requestMappingAndParamResults2";
//	}

	// test7 : Testing @RequestParam without name, value attributes
//	@RequestMapping(value = "/test7")
//	public String requestMappingAndParamTest7Subtest2(@RequestParam String empCount, Model model) {
//		model.addAttribute("orgName", empCount);
//		model.addAttribute("testSerial", "test7-subtest2");
//		return "requestMappingAndParamResults2";
//	}

	// test7 : Testing removal of  @RequestParam ambiguity with the same base URI but with different parameter
	@RequestMapping(value = "/test7", params="orgName")
	public String requestMappingAndParamTest7Subtest1(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test7-subtest1");
		return "requestMappingAndParamResults2";
	}

	// test7 : Testing removal of  @RequestParam ambiguity with the same base URI but with different parameter
	@RequestMapping(value = "/test7", params="empCount")
	public String requestMappingAndParamTest7Subtest2(@RequestParam String empCount, Model model) {
		model.addAttribute("orgName", empCount);
		model.addAttribute("testSerial", "test7-subtest2");
		return "requestMappingAndParamResults2";
	}
}
