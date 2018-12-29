package dao;

import java.util.List;

import entity.Company;

public interface CompanyDao {
	List<Company>selectCompany();
	
	/**
	 * 增加用户
	 */
	int insertCompany(Company comp);
	
	/**
	 * 根据name删除用户
	 */
	int deleteCompany(String name);
}
