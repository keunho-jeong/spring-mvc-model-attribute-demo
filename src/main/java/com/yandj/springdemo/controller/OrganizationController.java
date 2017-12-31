package com.yandj.springdemo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yandj.springdemo.domain.Organization;
import com.yandj.springdemo.service.OrganizationService;

@Controller
public class OrganizationController {

	final static Logger log = Logger.getLogger(OrganizationController.class);

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/getLocation")
	public String addLocation() {
		return "location";
	}

	// test
	@RequestMapping(value = "/getOrgList")
	public String listOrganization(Model model) {
		List<Organization> orgs = organizationService.getOrgList();
		model.addAttribute("orgList", orgs);
		log.debug("call /getOrgList " + orgs);
		return "listOrganizations";
	}
}
