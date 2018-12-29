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
		//1.加载驱动
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
		
		//2.获取连接
		//3.执行sql
		return data;
	}

	@Override
	public int insertCompany(Company comp) {
		Connection   conn = null;
		PreparedStatement    st = null;
		//1 加载驱动  2.获取连接 
		try {
			conn = DBUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.获取sql执行环境
		String sql = "insert into study01 values(?,?,?)";
		try {
			st = conn.prepareStatement(sql);
			// 设置参数 setXX
			st.setString(1,comp.getName());
			st.setInt(2,comp.getSex());
			st.setString(3,comp.getPosition());
			//执行sql处理返回值
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
		//1 加载驱动  2.获取连接 
		try {
			conn = DBUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.获取sql执行环境
		String sql = "delete from study01 where name = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			//4.执行sql  处理sql返回值 
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
