package com.yandj.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yandj.springdemo.dao.OrganizationDao;
import com.yandj.springdemo.domain.Organization;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getOrgList(){
		List<Organization> orgList = organizationDao.getAllOrganization();
		return orgList;
	}
	
}
