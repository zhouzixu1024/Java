package dao;

import java.util.List;

import entity.Company;

public interface CompanyDao {
	List<Company>selectCompany();
	
	/**
	 * �����û�
	 */
	int insertCompany(Company comp);
	
	/**
	 * ����nameɾ���û�
	 */
	int deleteCompany(String name);
}
