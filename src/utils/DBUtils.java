package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String DRIVER;

	static{
		ResourceBundle rb = ResourceBundle.getBundle("utils.dbconfig");
		URL = rb.getString("mysqlUrl");
		USER = rb.getString("mysqlUser");
		PASSWORD = rb.getString("mysqlPwd");
		DRIVER = rb.getString("mysqlDriver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	public static void closeRes(Connection conn,PreparedStatement ps,ResultSet rs)throws SQLException{
		if(conn!=null)
			conn.close();
			if(ps!=null)
				ps.close();
				if(rs!=null)
					rs.close();
			
		
	}
}