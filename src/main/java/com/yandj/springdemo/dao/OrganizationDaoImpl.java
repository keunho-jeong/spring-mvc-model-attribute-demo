package com.yandj.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yandj.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	final static Logger log = Logger.getLogger(OrganizationDaoImpl.class);

	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	public boolean create(Organization org) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(org);
		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("\nINSERT INTO organization (  ");
		sqlQuery.append("\n	company_name               ");
		sqlQuery.append("\n	,year_of_incorporation     ");
		sqlQuery.append("\n	,postal_code               ");
		sqlQuery.append("\n	,employee_count            ");
		sqlQuery.append("\n	,slogan                    ");
		sqlQuery.append("\n) VALUES (                  ");
		sqlQuery.append("\n	:companyName               ");
		sqlQuery.append("\n	,:yearOfIncorporation      ");
		sqlQuery.append("\n	,:postalCode               ");
		sqlQuery.append("\n	,:employeeCount            ");
		sqlQuery.append("\n	,:slogan                   ");
		sqlQuery.append("\n)                           ");
		
//		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
//				org.getEmployeeCount(), org.getSlogan() };
		
//		int idx = 0;
//		for(Object item:args){
//			log.info("SET PATAM:" + idx +" " + item);
//			idx++;
//		}
		return namedParameterJdbcTemplate.update(sqlQuery.toString(), params) == 1;
	}

	public Organization getOrganization(Integer id) {
		
		SqlParameterSource params = new MapSqlParameterSource("id",id);
		
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("\nSELECT    				");
		sqlQuery.append("\n  id                     ");
		sqlQuery.append("\n, company_name           ");
		sqlQuery.append("\n, year_of_incorporation  ");
		sqlQuery.append("\n, postal_code            ");
		sqlQuery.append("\n, employee_count         ");
		sqlQuery.append("\n, slogan                 ");
		sqlQuery.append("\nFROM organization        ");
		sqlQuery.append("\nWHERE id = :id           ");

//		Object[] args = new Object[] { id };

		// log.info(sqlQuery.toString());
		Organization org = namedParameterJdbcTemplate.queryForObject(sqlQuery.toString(), params, new OrganizationRowMapper());

		log.info(org);
		return org;

	}

	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
//		Object[] args = new Object[] { org.getId() };
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}

	public boolean update(Organization org) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		Object[] args = new Object[] { org.getSlogan(), org.getId() };
		return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}
