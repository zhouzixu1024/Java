package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Company;
import utils.DBUtils;

public class CompanyDaoImp implements CompanyDao {

	@Override
	public List<Company> selectCompany() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Company> data = new ArrayList<Company>();
		//1.��������
		try {
			conn = DBUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from study01";
		try{
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Company company = new Company();
					company.setName(rs.getString("name"));
					company.setSex(rs.getInt("sex"));
					company.setPosition(rs.getString("position"));
					data.add(company);
				}
	    }catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtils.closeRes(conn,ps,rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//2.��ȡ����
		//3.ִ��sql
		return data;
	}

	@Override
	public int insertCompany(Company comp) {
		Connection   conn = null;
		PreparedStatement    st = null;
		//1 ��������  2.��ȡ���� 
		try {
			conn = DBUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.��ȡsqlִ�л���
		String sql = "insert into study01 values(?,?,?)";
		try {
			st = conn.prepareStatement(sql);
			// ���ò��� setXX
			st.setString(1,comp.getName());
			st.setInt(2,comp.getSex());
			st.setString(3,comp.getPosition());
			//ִ��sql������ֵ
			 int rows = st.executeUpdate();
			    return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.closeRes(conn,st, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int deleteCompany(String name) {
		Connection   conn = null;
		PreparedStatement    st = null;
		//1 ��������  2.��ȡ���� 
		try {
			conn = DBUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.��ȡsqlִ�л���
		String sql = "delete from study01 where name = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			//4.ִ��sql  ����sql����ֵ 
		    int rows = st.executeUpdate();
		    return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.closeRes(conn,st, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
