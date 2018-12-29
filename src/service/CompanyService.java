package service;

import java.util.List;

import dao.CompanyDao;
import dao.CompanyDaoImp;
import entity.Company;

public class CompanyService {
	private CompanyDao dao;
	public CompanyService(){
		dao = new CompanyDaoImp();
	}
	public List<Company>CompanyAll(){
		return dao.selectCompany();
	}
	
}
